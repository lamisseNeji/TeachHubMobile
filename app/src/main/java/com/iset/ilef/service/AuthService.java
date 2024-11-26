package com.iset.ilef.service;

import com.iset.ilef.model.LoginRequest;
import com.iset.ilef.model.LoginResponse;
import com.iset.ilef.model.SignUpRequest;
import com.iset.ilef.model.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthService {
    @POST("/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    @POST("signup")
    Call<SignUpResponse> registerUser(@Body SignUpRequest signUpRequest);
}