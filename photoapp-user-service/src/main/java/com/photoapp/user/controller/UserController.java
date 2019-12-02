package com.photoapp.user.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.photoapp.user.dto.UserDto;
import com.photoapp.user.model.UserRequestModel;
import com.photoapp.user.model.UserResponseModel;
import com.photoapp.user.service.UsersService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private Environment environment;

	@Autowired
	private UsersService usersService;

	@GetMapping("/status/check")
	public String status() {
		return "Working on port = " + environment.getProperty("local.server.port") + ", with token = "
				+ environment.getProperty("token.secret");
	}

	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserResponseModel> createUser(@RequestBody final UserRequestModel requestModel) {
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		final UserDto userDto = modelMapper.map(requestModel, UserDto.class);

		final UserDto createdUser = usersService.createUser(userDto);

		final UserResponseModel responseModel = modelMapper.map(createdUser, UserResponseModel.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(responseModel);
	}

}
