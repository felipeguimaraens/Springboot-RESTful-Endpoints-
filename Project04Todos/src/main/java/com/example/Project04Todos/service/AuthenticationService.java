package com.example.Project04Todos.service;

import com.example.Project04Todos.request.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;

}
