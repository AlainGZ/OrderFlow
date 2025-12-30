package com.orderflow.orderflow_user_service.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder(toBuilder = true)
@Getter@Setter
public class User {

	private UUID id;
	private String name;
	private String lastname;
	private String email;
	private String passwordHash;
	private Instant createdAt;
}
