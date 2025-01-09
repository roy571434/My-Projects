package com.Spring.Backend.Service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.Spring.Backend.Entity.EmployeeEntity;

public interface EmployeeService {
   public List<EmployeeEntity> getAllEmployees();
   public EmployeeEntity createEmployee(EmployeeEntity employeeEntity);
   public ResponseEntity<EmployeeEntity> getEmployeeById(Long Id);
   public ResponseEntity<EmployeeEntity> updateEmployee (Long Id,EmployeeEntity employeeEntity);
   public ResponseEntity<Map<String , Boolean>> deleteEmployee(Long Id);
   
}
