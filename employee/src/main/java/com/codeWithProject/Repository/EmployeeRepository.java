package com.codeWithProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeWithProject.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
