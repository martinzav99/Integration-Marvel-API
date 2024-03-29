package com.martinzav.marvelChallenge.webController.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.martinzav.marvelChallenge.dto.security.LoginRequest;
import com.martinzav.marvelChallenge.dto.security.LoginResponse;
import com.martinzav.marvelChallenge.service.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;
    
    @PreAuthorize("permitAll")
    @PostMapping("/authenticate")
    public ResponseEntity<LoginResponse> authentication(@RequestBody @Valid LoginRequest loginRequest){
        return ResponseEntity.ok(authenticationService.aunthenticate(loginRequest));
    }

    @PreAuthorize("permitAll")
    @PostMapping("/logout")
    public void logout(){
        authenticationService.logout();
    }

}
