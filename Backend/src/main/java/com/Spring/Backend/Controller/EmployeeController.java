package com.Spring.Backend.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.Backend.Entity.EmployeeEntity;
import com.Spring.Backend.Service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@Configuration
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Get Employee list Rest API
    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmp() {
        return employeeService.getAllEmployees();
    }

    // Create Employee Rest API
    @PostMapping("/employees")
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.createEmployee(employeeEntity);
    }

    // Get element by id Rest API
    @GetMapping("/employees/{Id}")
    public ResponseEntity<EmployeeEntity> getEmpById(@PathVariable Long Id){
        return employeeService.getEmployeeById(Id); 
    }

    // update employee Rest API
    @PutMapping("/employees/{Id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Long Id, @RequestBody EmployeeEntity employeeEntity){
        return employeeService.updateEmployee(Id, employeeEntity);
    }
    
    // delete employee Rest API   
    @DeleteMapping("/employees/{Id}")
    public ResponseEntity<Map<String ,Boolean>> deleteEmployee(@PathVariable Long Id){
        return employeeService.deleteEmployee(Id);
    }
     


       
    
   
}
    