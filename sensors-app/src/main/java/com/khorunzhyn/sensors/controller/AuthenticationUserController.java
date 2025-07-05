package com.khorunzhyn.sensors.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Tag(name = "Users", description = "Requester roles lifecycle")
public class AuthenticationUserController {
    @Operation(summary = "Get user role from database")
    @GetMapping("/test")
    public String test(Authentication authentication) {
        System.out.println("User roles: " + authentication.getAuthorities());
        return authentication.getAuthorities().toString();
    }
}
