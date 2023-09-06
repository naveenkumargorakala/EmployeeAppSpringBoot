package com.example.employeespring.service;

import com.example.employeespring.model.EmployeeModel;
import com.example.employeespring.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    //Adding Employee Data
    public EmployeeModel createEmp(EmployeeModel model) {
//        EmployeeModel employee = new EmployeeModel(model);
        repository.save(model);
        return  repository.save(model);
    }

    //Showing All Employees Data
    public List<EmployeeModel> allEmps() {
        List<EmployeeModel> employees = repository.findAll();
        return employees;
    }

    //Delete Employee Data By Using ID
    public String deleteEmp(int id) {
        boolean isEmployeeData = repository.existsById(id);
        if(isEmployeeData == true){
            repository.deleteById(id);
        }
        return id+" Employees data is Deleted";
    }


    //Get the Employee Data By Using ID
    public EmployeeModel getEmployee(int id) {
        Optional<EmployeeModel> employee = repository.findById(id);
        return employee.get();
    }

    //Update the Employee Data by using ID
    public EmployeeModel updateEmployee(EmployeeModel model,int id) {

        EmployeeModel employee = repository.findById(id).get();
        employee.setName(model.getName());
        employee.setGender(model.getGender());
        employee.setEmail(model.getEmail());
        employee.setPhoneNumber(model.getPhoneNumber());
        employee.setProfilePic(model.getProfilePic());
        employee.setDepartment(model.getDepartment());
        employee.setSalary(model.getSalary());
        employee.setStartDate(model.getStartDate());
        employee.setNotes(model.getNotes());
        repository.save(employee);
        return employee;
    }

}
