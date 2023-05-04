package com.infy.main.app.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infy.main.app.model.User;
import com.infy.main.app.response.BaseResponse;
import com.infy.main.app.servicei.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService userservice;
	
	@PostMapping("/adduser")
	public ResponseEntity<BaseResponse<User>> addUserMethod(@RequestBody User user)
	{
		User us=userservice.addUser(user);
		BaseResponse<User> baseResponse=new BaseResponse<User>(200, new Date(), "User Added SucessFully", us);
		ResponseEntity<BaseResponse<User>> entity =new ResponseEntity<BaseResponse<User>>(baseResponse, HttpStatus.OK);
		
		return entity;
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<BaseResponse<List<User>>> getuser(){
		
		List<User> getuser=userservice.getalluser();
		BaseResponse<List<User>> baseResponse=new BaseResponse (200, new Date(),"Data Is Get Sucessfully", getuser);
		ResponseEntity<BaseResponse<List<User>>> entity =new ResponseEntity (baseResponse, HttpStatus.OK);
		
		return entity;
		
		
		
	}
	
	
	
}
