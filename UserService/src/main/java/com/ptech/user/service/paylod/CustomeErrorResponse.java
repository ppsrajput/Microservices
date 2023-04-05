package com.ptech.user.service.paylod;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomeErrorResponse {
	
	private String message;
	private boolean success;
	private HttpStatus httpStatus;

}
