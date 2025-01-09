package com.Spring.Backend.Service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Spring.Backend.Entity.EmployeeEntity;
import com.Spring.Backend.Repository.EmployeeRepo;
import com.Spring.Backend.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        return employeeRepo.save(employeeEntity);
    }

    @Override
    public ResponseEntity<EmployeeEntity> getEmployeeById(Long Id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(Id).orElseThrow();
        return ResponseEntity.ok(employeeEntity);
    }

    @Override
    public ResponseEntity<EmployeeEntity> updateEmployee(Long id, EmployeeEntity employeeDetails) {
        EmployeeEntity employeeEntity = employeeRepo.findById(id).orElseThrow();
        
        // Update the properties of the fetched employeeEntity with the properties of updatedEmployeeEntity
        employeeEntity.setFirstName(employeeDetails.getFirstName());
        employeeEntity.setLastName(employeeDetails.getLastName());
        employeeEntity.setEmailId(employeeDetails.getEmailId());
       
        
        // Save the updated entity back to the repository
        EmployeeEntity updateEmployee = employeeRepo.save(employeeEntity);
        
        // Return ResponseEntity with the updated EmployeeEntity
        return ResponseEntity.ok(updateEmployee);
    }

    @Override
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(Long Id) {
        EmployeeEntity employeeEntity = employeeRepo.findById(Id).orElseThrow();
        employeeRepo.delete(employeeEntity);
        Map<String , Boolean> response = new HashMap();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
   
}

