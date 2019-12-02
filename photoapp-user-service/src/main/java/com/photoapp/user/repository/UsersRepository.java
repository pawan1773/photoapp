package com.photoapp.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.photoapp.user.entity.UserEntity;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByEmail(final String email);

	UserEntity findByUserId(final String userId);

}
