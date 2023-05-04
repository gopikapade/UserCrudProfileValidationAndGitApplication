package com.infy.main.app.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.main.app.model.User;

public interface UserRepositry extends JpaRepository<User, Integer> {

}
