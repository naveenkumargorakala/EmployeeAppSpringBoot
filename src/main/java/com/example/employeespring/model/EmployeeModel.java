package com.example.employeespring.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class EmployeeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String gender;
    private String email;
    private long phoneNumber;
    @ElementCollection
    private List<String> department;
    private String profilePic;
    private long salary;
    private Date startDate;
    private String notes;



}
