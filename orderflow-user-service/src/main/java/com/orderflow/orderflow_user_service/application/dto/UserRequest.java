package com.orderflow.orderflow_user_service.application.dto;

import lombok.Data;

@Data
public class UserRequest {
	private String name;
	private String email;
	private String password;
}
