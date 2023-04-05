package com.ptech.user.service.request.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {
	
	private Integer id;
	private String name;
	private String email;
	private String about;
	private List<FriendRequestDTO> friends;

}
