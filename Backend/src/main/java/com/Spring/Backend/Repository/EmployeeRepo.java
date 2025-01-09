package com.Spring.Backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Spring.Backend.Entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>
{
        
}
