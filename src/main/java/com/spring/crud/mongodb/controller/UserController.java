package com.spring.crud.mongodb.controller;

import com.spring.crud.mongodb.dto.UserCountResponseDTO;
import com.spring.crud.mongodb.dto.UserDTO;
import com.spring.crud.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private List<UserDTO> findAllUsers(){
        return userService.findAll();
    }

    @RestController
    public class HomeController {

        //Testing just "/"
        @GetMapping("/")
        public String home() {
            return "🚀 Aplicação Spring Boot + MongoDB rodando!";
        }
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserDTO> inserUser(@RequestBody UserDTO userDTO){
        UserDTO savedUser = userService.createUser(userDTO);
        return ResponseEntity.ok(savedUser);

    }



    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        UserDTO user = userService.findById(id); // Lança ResourceNotFoundException se não existir
        return ResponseEntity.ok(user); // 200 OK + JSON do usuário
    }

    //Verify how many user exists in the database
    @GetMapping("/count")
    public UserCountResponseDTO getUserCount() {
        long total = userService.countUsers();
        return new UserCountResponseDTO(total);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id) {
        userService.deleteById(id);
        return new ResponseEntity<String>("User with id " + id + " successfully deleted" ,HttpStatus.OK);
    }

}
