package com.example.employeespring.service;

import com.example.employeespring.model.EmployeeModel;
import org.springframework.stereotype.Service;

@Service
public interface IEmployee {
    public EmployeeModel createEmp(EmployeeModel model);
}
