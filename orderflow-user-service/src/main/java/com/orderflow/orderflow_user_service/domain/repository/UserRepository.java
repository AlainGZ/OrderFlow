package com.orderflow.orderflow_user_service.domain.repository;

import com.orderflow.orderflow_user_service.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

	User save(User user);


	Optional<User> findByEmail(String email);
	boolean existsByEmail(String email);
}
