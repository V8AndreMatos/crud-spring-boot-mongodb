package com.spring.crud.mongodb.service;

import com.spring.crud.mongodb.dto.UserDTO;
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

    public List<UserDTO> findAll(){

        return userRepository.findAll().stream().map( x -> new UserDTO(x)).toList();
    }

    public Optional<UserDTO> findById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::new);
    }


    public UserDTO createUser(UserDTO userDTO){

        UserEntity userEntity = new UserEntity(null,userDTO.getName(), userDTO.getEmail());
        return new UserDTO(userRepository.save(userEntity));
    }

    public Optional<UserDTO> update(Long id, UserDTO dto) {
        return userRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            return new UserDTO(userRepository.save(existing));
        });
    }

    public void deleteById(Long id){
        userRepository.findById(id);
    }

}
