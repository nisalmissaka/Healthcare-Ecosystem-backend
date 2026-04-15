package edu.example.service;

import edu.example.model.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {
    public Map<String, String> authenticateUser(LoginRequest loginRequest) {
        Map<String,String> response = new HashMap<>();

        if("nisal".equals(loginRequest.getUsername()) && "0764456476".equals(loginRequest.getPhoneNumber())){
            response.put("status","success");
            response.put("massage","Welcome to Healthcare Ecosystem!");
            response.put("user",loginRequest.getUsername());
        } else {
            response.put("status","error");
            response.put("massage","Invalid Username or Phone Number");
        }
       return response;
    }
}
