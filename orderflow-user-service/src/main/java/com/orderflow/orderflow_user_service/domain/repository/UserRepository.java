package com.orderflow.orderflow_user_service.domain.repository;

import com.orderflow.orderflow_user_service.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllById(Long documentId);

}
