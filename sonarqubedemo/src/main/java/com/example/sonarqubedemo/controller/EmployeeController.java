package com.example.sonarqubedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sonarqubedemo.service.EmployeeService;
import com.example.sonarqubedemo.appexception.RecordNotFoundException;
import com.example.sonarqubedemo.entity.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	@GetMapping(value = "/getall")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> list = service.getAllEmployees();

		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	

	@PostMapping(value = "/create")
	public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee)
			throws RecordNotFoundException {
		Employee updated = service.createOrUpdateEmployee(employee);
		return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteEmployeeById(id);
		return HttpStatus.FORBIDDEN;
	}

	@GetMapping(value = "last/{key}")
	public Employee readByLastName(@PathVariable("key") String lastName) {
	

		return service.getByLastname(lastName);
	}
	@GetMapping(value = "firstlast/{key1}/{key2}")
	public List<Employee> readByFirstNameAndLastName(@PathVariable("key1") String firstName,@PathVariable("key2") String lastName) {

		return service.getByFirstNameAndLastname(firstName, lastName);
	
	}
	@GetMapping(value = "namedquery/{key1}")
	public List<Employee> namedByQuery(@PathVariable("key1") String firstName) {

		return service.namedQuery(firstName);
	
	}
	
	@GetMapping(value = "directquery/{key1}")
	public List<Employee> directQuery(@PathVariable("key1") String firstName) {

		return service.directQuery(firstName);
	
	}
	@GetMapping(value = "/producer")
	public String myfunction()
	{
		return "welcome from controller from springbootjpa_h2 project";
	}
	
	@GetMapping("fetch/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Employee entity = service.getEmployeeById(id);

		return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	
	
	
}
