package com.pl.emailOtpVerification.controller;

import com.pl.emailOtpVerification.requests.RegisterRequest;
import com.pl.emailOtpVerification.responses.RegisterResponse;
import com.pl.emailOtpVerification.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest registerRequest){
        RegisterResponse registerResponse = userService.register(registerRequest);
        return new ResponseEntity<>(registerResponse, HttpStatus.CREATED);
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyUser(@RequestParam String email,@RequestParam String otp){
        try {
            userService.verify(email, otp);
            return new ResponseEntity<>("User verified successfully",HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
