package com.example.employeespring.contoller;

import com.example.employeespring.model.EmployeeModel;
import com.example.employeespring.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/employee")

public class EmployeeController {

    @Autowired
    EmployeeService service;

//    http://localhost:8088/employee/addemployee
    @PostMapping("/addemployee")
    public EmployeeModel addEmp(@RequestBody EmployeeModel model){
        EmployeeModel employee = service.createEmp(model);
        return employee;

    }


  //  http://localhost:8088/employee/allemployees
    @GetMapping("/allemployees")
    public List<EmployeeModel> showData(){
        List< EmployeeModel> employees = service.allEmps();
        return employees;
    }


    @GetMapping("/getbyid/{id}")
    public EmployeeModel employeeData(@PathVariable int id){
        EmployeeModel employee = service.getEmployee(id);
        return  employee;
    }



    @DeleteMapping("/deletebyid/{id}")
    public void deleteData(@PathVariable int id){
        String employee = service.deleteEmp(id);
        System.out.println(id+" Employees data is Deleted");
    }

    @PutMapping("/updateemployee/{id}")
    public EmployeeModel updateEmp(@RequestBody EmployeeModel model,@PathVariable int id){
        EmployeeModel employee = service.updateEmployee(model,id);
        return employee;
    }
}


