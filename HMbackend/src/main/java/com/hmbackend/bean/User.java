package com.hmbackend.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private String role;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
