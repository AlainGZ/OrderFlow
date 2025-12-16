package com.orderflow.orderflow_user_service.infraestructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByEmail(String email);
	boolean existsByEmail(String email);
}
