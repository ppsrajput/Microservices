package com.ptech.user.service.service;

import com.ptech.user.service.entities.User;
import com.ptech.user.service.request.dto.UserRequestDTO;

import java.util.List;

public interface UserService {
	
	User createUser(UserRequestDTO user);
	User updateUser(UserRequestDTO user);
	void deleteUser(Integer id);
	User getUser(Integer id);
	List<User> getAllUsers();

}
