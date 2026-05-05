package edu.example.controller;

import edu.example.dto.DashboardDTO;
import edu.example.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/stats")
    public ResponseEntity<DashboardDTO> getDashboardStats(){
        DashboardDTO stats = new DashboardDTO();
        stats.setNextAppointment("April 12, 10.00 AM - Dr.Silva");
        stats.setPendingBills(4500.00);
        stats.setNewReports(3);
        stats.setActivityData(Arrays.asList(50,65,75,95,115,222));
        return  ResponseEntity.ok(stats);
    }
}
