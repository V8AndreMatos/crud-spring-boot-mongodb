package com.spring.crud.mongodb.repository;

import com.spring.crud.mongodb.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, Long> {
}
