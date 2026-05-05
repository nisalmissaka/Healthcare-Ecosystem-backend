package edu.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {
    private String nextAppointment;
    private double pendingBills;
    private int newReports;
    private List<Integer> activityData;
}
