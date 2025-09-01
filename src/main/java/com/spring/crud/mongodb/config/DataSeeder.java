package com.spring.crud.mongodb.config;

import com.spring.crud.mongodb.dto.UserDTO;
import com.spring.crud.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private final UserRepository userRepository;

    public DataSeeder(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        userRepository.deleteAll(); // limpa antes de inserir

        UserDTO u1 = new UserDTO();
        u1.setId("1");
        u1.setName("André Matos");
        u1.setEmail("andre@email.com");

        UserDTO u2 = new UserDTO();
        u2.setId("2");
        u2.setName("Soraia Garcia");
        u2.setEmail("soraia@email.com");

        UserDTO u3 = new UserDTO();
        u3.setId("3");
        u3.setName("Julia Matos");
        u3.setEmail("julia@email.com");

        UserDTO u4 = new UserDTO();
        u4.setId("4");
        u4.setName("Testing");
        u4.setEmail("testing@email.com");

        UserDTO u5 = new UserDTO();
        u5.setId("5");
        u5.setName("Testing new user");
        u5.setEmail("newuser@email.com");

        userRepository.save(u1.toEntity());
        userRepository.save(u2.toEntity());
        userRepository.save(u3.toEntity());
        userRepository.save(u4.toEntity());
        userRepository.save(u5.toEntity());

        System.out.println("Data inserted into MongoDB!");
    }
}

