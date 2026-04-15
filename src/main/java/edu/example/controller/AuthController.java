package edu.example.controller;

import edu.example.model.LoginRequest;
import edu.example.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:59080")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Map<String,String> result = authService.authenticateUser(loginRequest);

        if ("Nisal".equals(loginRequest.getUsername()) &&
                "0764456476".equals(loginRequest.getPhoneNumber())) {

            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "message", "Welcome to Healthcare Ecosystem!",
                    "user", loginRequest.getUsername()
            ));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of(
                    "status", "error",
                    "message", "Invalid Username or Phone Number"
            ));
        }
    }
}
