package com.ptech.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptech.user.service.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
