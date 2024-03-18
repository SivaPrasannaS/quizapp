package com.maxneo.quizapp.service;

import com.maxneo.quizapp.dto.request.LoginRequest;
import com.maxneo.quizapp.dto.request.RegisterRequest;
import com.maxneo.quizapp.dto.response.LoginResponse;

public interface AuthenticationService {

    String register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);

}
