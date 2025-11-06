package com.example.Project04Todos.service;

import com.example.Project04Todos.request.AuthenticationRequest;
import com.example.Project04Todos.request.RegisterRequest;
import com.example.Project04Todos.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
    AuthenticationResponse login(AuthenticationRequest request);
}
