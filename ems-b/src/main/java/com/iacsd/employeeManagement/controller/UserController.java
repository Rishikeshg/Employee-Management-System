package com.iacsd.employeeManagement.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iacsd.employeeManagement.model.Login;
import com.iacsd.employeeManagement.model.User;
import com.iacsd.employeeManagement.service.CommonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api2/v2")
public class UserController {
	private static final Logger LOGGER = Logger.getLogger(UserController.class);
	
	@Autowired
	private CommonService commonService;

	@PostMapping("/addUser")
	public Long createUser(@Valid @RequestBody User user) {
		LOGGER.info(user);
		return commonService.saveUser(user);
	}

	@PostMapping("/login")
	public ResponseEntity<User> login(@Valid @RequestBody Login login) {
		LOGGER.info(login);
		User user = commonService.userLogin(login);
		if (user !=null) {
			return ResponseEntity.ok(user);
		}
		return null;
	}
}
