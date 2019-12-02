package com.photoapp.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.photoapp.user.dto.UserDto;

public interface UsersService extends UserDetailsService {

	UserDto createUser(UserDto userDetails);

	UserDto getUserDetailsByEmail(String email);

	UserDto getUserByUserId(String userId);
}
