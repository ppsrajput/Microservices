package com.ptech.hotel.request.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelRequestDTO {

	private String id;
	private String name;
	private String location;
	private String about;

}
