package com.orderflow.orderflow_user_service.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor@NoArgsConstructor
@Builder(toBuilder = true)
public class User {
	private String name;
	private String lastname;
	private Long documentId;
	private String email;
	private String Password;
}
