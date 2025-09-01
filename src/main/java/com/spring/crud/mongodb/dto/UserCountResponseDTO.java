package com.spring.crud.mongodb.dto;

public class UserCountResponseDTO {
    private long totalUsers;

    public UserCountResponseDTO() {
    }

    public UserCountResponseDTO(long totalUsers) {
        this.totalUsers = totalUsers;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public void setTotalUsers(long totalUsers) {
        this.totalUsers = totalUsers;
    }
}

