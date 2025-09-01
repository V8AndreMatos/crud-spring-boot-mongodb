package com.spring.crud.mongodb.service;

import com.spring.crud.mongodb.dto.UserDTO;
import com.spring.crud.mongodb.exceptions.ResourceNotFoundException;
import com.spring.crud.mongodb.entity.UserEntity;
import com.spring.crud.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    //Finf a list of users
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserDTO::new)
                .toList();
    }

    //Find a user by ID
    public UserDTO findById(String id){
        System.out.println(">>>Searching for user with ID : " + id);
        UserEntity user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with  id " +id));
        return new UserDTO(user);
    }

    // Create and save a new User
    public UserDTO createUser(UserDTO userDTO){

        UserEntity userEntity = new UserEntity(null,userDTO.getName(), userDTO.getEmail());
        return new UserDTO(userRepository.save(userEntity));
    }

    //Update a user
    public Optional<UserDTO> update(String id, UserDTO dto) {
        return userRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            return new UserDTO(userRepository.save(existing));
        });
    }

    //Delete by ID
    public void deleteById(String id ){

        if (!userRepository.existsById(id)){
            throw new ResourceNotFoundException(id);
        }

        userRepository.deleteById(id);
    }

    //Verify how many user exists in the database
    public long countUsers() {
        return userRepository.count(); // já vem pronto do MongoRepository
    }
}
