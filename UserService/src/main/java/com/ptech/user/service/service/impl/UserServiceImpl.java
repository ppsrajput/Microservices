package com.ptech.user.service.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptech.user.service.entities.Friend;
import com.ptech.user.service.entities.User;
import com.ptech.user.service.exceptions.Errors;
import com.ptech.user.service.exceptions.UserNotFoundException;
import com.ptech.user.service.repository.UserRepository;
import com.ptech.user.service.request.dto.FriendRequestDTO;
import com.ptech.user.service.request.dto.UserRequestDTO;
import com.ptech.user.service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	private UserRepository repository;
	
	@Inject
	private Provider<User> userBean;
	
	@Override
	public User createUser(UserRequestDTO dto) {
		if(dto!=null) {
			User user=userBean.get();
			
			user.setName(dto.getName());
			user.setEmail(dto.getEmail());
			user.setAbout(dto.getAbout());
			
			if(dto.getFriends()!=null && !dto.getFriends().isEmpty()) {
				List<Friend> friends = dto.getFriends().stream().map((friend)->{
					
					return Friend.builder().id(UUID.randomUUID().toString()).name(friend.getName()).address(friend.getAddress()).user(user).build();
				}).collect(Collectors.toList());
				user.setFriends(friends);
			}
			
			return this.repository.save(user);
		}
		return null;
		
	}

	@Override
	public User updateUser(UserRequestDTO dto) {
		User user=this.repository.findById(dto.getId()).get();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setAbout(dto.getAbout());
		if (dto.getFriends() != null && !dto.getFriends().isEmpty()) {
			List<Friend> friends = dto.getFriends().stream().map((friend) -> {
				if (friend.getId() != null) {
					return Friend.builder().id(friend.getId()).name(friend.getName()).address(friend.getAddress())
							.user(user).build();
				} else {
					return Friend.builder().id(UUID.randomUUID().toString()).name(friend.getName())
							.address(friend.getAddress()).user(user).build();
				}
			}).collect(Collectors.toList());
			System.out.println(user.getFriends().hashCode());
			user.getFriends().clear();
			user.getFriends().addAll(friends);
			System.out.println(user.getFriends().hashCode());
		}
		User savedUser = this.repository.saveAndFlush(user);
		System.out.println(savedUser.getFriends().hashCode());
		return savedUser;
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		this.repository.deleteById(id);	}

	@Override
	public User getUser(Integer id) {
		return this.repository.findById(id).orElseThrow(() -> new UserNotFoundException(Errors.USER_NOT_FOUND+" with given Id "+id));
	}

}
