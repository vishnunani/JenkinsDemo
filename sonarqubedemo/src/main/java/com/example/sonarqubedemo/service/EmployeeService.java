package com.example.sonarqubedemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sonarqubedemo.appexception.RecordNotFoundException;
import com.example.sonarqubedemo.entity.Employee;

import com.example.sonarqubedemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<Employee>();
		}
	}

	public Employee getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Employee createOrUpdateEmployee(Employee employee) throws RecordNotFoundException {
		Optional<Employee> employeeExisting = employeeRepository.findById(employee.getId());
		if (employeeExisting.isPresent()) {
			Employee oldEntity = employeeExisting.get();
			oldEntity.setFirstName(employee.getFirstName());
			oldEntity.setLastName(employee.getLastName());
			oldEntity.setEmail(employee.getEmail());
			employee = employeeRepository.save(oldEntity);
			return employee;
		} else {
			employee = employeeRepository.save(employee);
			return employee;
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Employee getByLastname(String lastName)
	{
	
	
		return employeeRepository.findByLastName(lastName);
		}

	public List<Employee> getByFirstNameAndLastname(String firstName,String lastName)
		{
			return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
		}
	public List<Employee> namedQuery(String arg)
	{
		return employeeRepository.anyName(arg);
	}
	
	
	public List<Employee> directQuery(String arg)
	{
		return employeeRepository.findByFirstNameEndsWith(arg);
	}
	
	
}