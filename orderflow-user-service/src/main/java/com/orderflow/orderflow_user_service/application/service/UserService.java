package com.orderflow.orderflow_user_service.application.service;

import com.orderflow.orderflow_user_service.application.dto.UserRequest;
import com.orderflow.orderflow_user_service.application.dto.UserResponse;

public interface UserService {
	UserResponse register(UserRequest request);
	String login(String email, String password);

}
