package com.pl.emailOtpVerification.service;

import com.pl.emailOtpVerification.requests.RegisterRequest;
import com.pl.emailOtpVerification.responses.RegisterResponse;

public interface UserService {

    RegisterResponse register(RegisterRequest registerRequest);

    void verify(String email,String otp);
}
