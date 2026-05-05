package edu.example.service;

import edu.example.dto.DashboardDTO;
import edu.example.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DashboardService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public DashboardDTO getSummary(){
        return new DashboardDTO("April 12, 10:00 AM - Dr. Silva", 4500.00, 3,
        Arrays.asList(50,65,75,95,115,122));
    }
}
