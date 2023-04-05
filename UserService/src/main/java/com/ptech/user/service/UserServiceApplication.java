package com.ptech.user.service;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ptech.user.service.entities.User;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(UserServiceApplication.class, args);
		ObjectMapper mapper = new ObjectMapper();

		// read JSON file and map/convert to java POJO
		try {
		    Object someClassObject = mapper.readValue(new File("src/main/resources/DB - Extract - VF - JSON.json"), Object.class);
		    System.out.println(someClassObject);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	@Bean
	@Scope ("prototype")
	public User user() {
		return new User();
	}

}
