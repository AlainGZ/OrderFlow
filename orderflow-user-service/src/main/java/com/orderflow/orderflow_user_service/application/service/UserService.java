package com.orderflow.orderflow_user_service.application.service;

public class UserService {
	UserResponse registr(UserRequest request);
	String login(String email, String password);

}
