package edu.example.service;

import edu.example.model.User;
import edu.example.model.LoginRequest;
import edu.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<String, String> authenticateUser(LoginRequest loginRequest) {
        Map<String,String> response = new HashMap<>();

        System.out.println("Login Attempt Username: " + loginRequest.getUsername());

        Optional<User> userOpt = userRepository.findByEmail(loginRequest.getUsername());

        if (userOpt.isPresent()) {
            System.out.println("User Found in DB!");
            User user = userOpt.get();

            if (user.getEmail().equals(loginRequest.getEmail())) {
                response.put("status", "success");
                response.put("message", "Welcome to Healthcare Ecosystem!");
                response.put("user", user.getUsername());
            } else {
                System.out.println("Phone Mismatch! DB value: " + user.getEmail());
                response.put("status", "error");
                response.put("message", "Invalid Phone Number");
            }
        } else {
            System.out.println("User NOT found in Database!");
            response.put("status", "error");
            response.put("message", "User not found");
        }
        return response;
    }
}
