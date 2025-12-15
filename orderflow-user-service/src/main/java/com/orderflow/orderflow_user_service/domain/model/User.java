package com.orderflow.orderflow_user_service.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder(toBuilder = true)
public class User {

	private Long id;
	private String name;
	private String lastname;
	private String email;
	private String passwordHash;
	private Instant createdAt;
}
