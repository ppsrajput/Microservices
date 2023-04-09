package com.ptech.user.service.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	private String email;
	private String about;
	@OneToMany(mappedBy = "user",cascade=CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference
	private List<Friend> friends=new ArrayList<>();
	@Transient
	private List<Rating> ratings=new ArrayList<>();
	

}
