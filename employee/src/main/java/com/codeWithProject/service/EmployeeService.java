package com.codeWithProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeWithProject.Entity.Employee;
import com.codeWithProject.Repository.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee postEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
				
	}
	
	public void deleteEmployee(Long id) {
		if(!employeeRepository.existsById(id)) {
			throw new EntityNotFoundException("Employee with ID"+id+" not found");
		}
		employeeRepository.deleteById(id);
	}
	
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}
	
	public Employee updateEmployee(Long id, Employee employee) {
		Optional<Employee> optionalEmployee=employeeRepository.findById(id);
		if(optionalEmployee.isPresent()) {
			Employee exixtingEmployee=optionalEmployee.get();
			
			exixtingEmployee.setEmail(employee.getEmail());
			exixtingEmployee.setName(employee.getName());
			exixtingEmployee.setPhone(employee.getPhone());
			exixtingEmployee.setDepartment(employee.getDepartment());
			
			return employeeRepository.save(exixtingEmployee);
		}
		return null;
	}
}
