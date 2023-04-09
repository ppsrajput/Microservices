package com.ptech.user.service.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.inject.Provider;

import com.ptech.user.service.entities.Hotel;
import com.ptech.user.service.entities.Rating;
import com.ptech.user.service.externel.service.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ptech.user.service.entities.Friend;
import com.ptech.user.service.entities.User;
import com.ptech.user.service.exceptions.Errors;
import com.ptech.user.service.exceptions.UserNotFoundException;
import com.ptech.user.service.repository.UserRepository;
import com.ptech.user.service.request.dto.FriendRequestDTO;
import com.ptech.user.service.request.dto.UserRequestDTO;
import com.ptech.user.service.service.UserService;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Inject
	private Provider<User> userBean;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

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
		this.repository.deleteById(id);	}

	@Override
	public User getUser(Integer id) {
		User user = this.repository.findById(id).orElseThrow(() -> new UserNotFoundException(Errors.USER_NOT_FOUND + " with given Id " + id));
		//get user ratings
		//http://RATING-SERVICE/rating/user/2
		Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+id, Rating[].class);
		if(ratings!=null){
			List<Rating> ratingsOfUser = Arrays.stream(ratings).map(rating -> {

				//get hotel by id from hotel service
				//ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
				//if (hotelResponseEntity.getStatusCode().equals(HttpStatus.OK)) {
				//	rating.setHotel(hotelResponseEntity.getBody());
				//}
				Hotel hotel=this.hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				return rating;
			}).collect(Collectors.toList());
			user.setRatings(ratingsOfUser);
			log.info("{} ",ratingsOfUser);
		}
		return user;
	}
	@Override
	public List<User> getAllUsers(){

		List<User> userList = this.repository.findAll();
		if(!userList.isEmpty()){
			userList.stream().peek(user -> {
				Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getId(), Rating[].class);
				if(ratings!=null){
					List<Rating> ratingsOfUser = Arrays.stream(ratings).peek(rating -> {

						//get hotel by id from hotel service
//						ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//						if (hotelResponseEntity.getStatusCode().equals(HttpStatus.OK)) {
//							rating.setHotel(hotelResponseEntity.getBody());
//						}
						Hotel hotel=this.hotelService.getHotel(rating.getHotelId());
						rating.setHotel(hotel);
					}).collect(Collectors.toList());
					user.setRatings(ratingsOfUser);
					log.info("{} ",ratingsOfUser);
				}

			}).collect(Collectors.toList());
		}
		return userList;
	}

}
