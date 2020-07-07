package com.example.petshop.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.petshop.dto.LoginRequestDto;
import com.example.petshop.service.UserService;


@RestController
public class UserController {
	private static Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	UserService userService;
	@PostMapping("/users/login")
	public String authenticateUser(@Valid @RequestBody LoginRequestDto loginRequestDto) throws InvalidCredentialsException {
		logger.info("authenticating the user");
		boolean isExists;
		isExists = userService.authenticateUser(loginRequestDto.getUserName(), loginRequestDto.getPassword());
		if (isExists)
			return "logged in successfully";
		else {
			return "Credentials are incorrect";
		}
	}

}
