package com.example.Project04Todos.service;

import com.example.Project04Todos.response.UserResponse;

public interface UserService {
    UserResponse getUserInfo();
    void deleteUser();
}
