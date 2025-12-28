package com.orderflow.orderflow_user_service.application.service;

import com.orderflow.orderflow_user_service.application.dto.UserRequest;
import com.orderflow.orderflow_user_service.application.dto.UserResponse;
import com.orderflow.orderflow_user_service.domain.model.User;
import com.orderflow.orderflow_user_service.domain.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.util.UUID;

public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final JwtUtil jwtUtil;

	public UserServiceImpl(UserRepository userRepository,
						   BCryptPasswordEncoder passwordEncoder,
						   JwtUtil jwtUtil){

		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public UserResponse register(UserRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new EmailAlreadyRegisteredException();
		}
		String hash = passwordEncoder.encode(request.getPassword());
		User user = new User(UUID.randomUUID(), request.getName(), request.getEmail(), hash, Instant.now());
		User saved = userRepository.save(user);
		return new UserResponse(saved.getId().toString(), saved.getName(), saved.getEmail(), saved.getCreatedAt());
	}

	@Override
	public String login(String email, String password) {
		User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Invalid credentials"));
		if (!passwordEncoder.matches(password, user.getPasswordHash())) {
			throw new RuntimeException("Invalid credentials");
		}
		return jwtUtil.generateToken(user.getId().toString(), user.getEmail());
	}
}
