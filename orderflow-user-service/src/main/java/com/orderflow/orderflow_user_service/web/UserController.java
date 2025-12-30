package com.orderflow.orderflow_user_service.web;

import com.orderflow.orderflow_user_service.application.dto.UserRequest;
import com.orderflow.orderflow_user_service.application.dto.UserResponse;
import com.orderflow.orderflow_user_service.application.service.UserService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private UserService userService;

	public UserController(UserService userService){
		this.userService = userService;
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponse> register(@RequestBody UserRequest req){
		UserResponse res = userService.register(req);
		return ResponseEntity.status(201).body(res);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest req){
		String token = userService.login(req.getEmail(), req.getPassword());
		return ResponseEntity.ok(new JwtResponse(token));
	}
}

@Data
class LoginRequest {
	private String email;
	private String password;
}

class JwtResponse {
	private String token;

	public JwtResponse(String token){
		this.token=token;
	}

	public String getToken(){
		return token;
	}
}