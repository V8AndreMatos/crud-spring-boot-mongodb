package com.spring.crud.mongodb.controller;

import com.spring.crud.mongodb.dto.UserDTO;
import com.spring.crud.mongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        @GetMapping("/")
        public String home() {
            return "🚀 Aplicação Spring Boot + MongoDB rodando!";
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id){
        return userService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/test")
    public String testMongo() {
        long count = userService.count();
        return "MongoDB conectado! Total de usuários: " + count;
    }



}
