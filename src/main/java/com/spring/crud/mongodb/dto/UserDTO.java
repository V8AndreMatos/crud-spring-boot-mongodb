package com.spring.crud.mongodb.dto;

import com.spring.crud.mongodb.entity.UserEntity;

public class UserDTO {

    private String id;
    private String name;
    private String email;

    public UserDTO(){

    }

    public UserEntity toEntity() {
        return new UserEntity(id, name, email);
    }


    public UserDTO(UserEntity entity){

        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
