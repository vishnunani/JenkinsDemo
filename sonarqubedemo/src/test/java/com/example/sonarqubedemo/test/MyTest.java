package com.example.sonarqubedemo.test;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.sonarqubedemo.appexception.RecordNotFoundException;
import com.example.sonarqubedemo.entity.Employee;
import com.example.sonarqubedemo.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = { MyTest1.class })
public class MyTest {
	private EmployeeService employeeService;
	Employee employee=new Employee("vishnu","vardhan","vishnu@gmail.com");
	
	
	
	@Test
	public void one() throws RecordNotFoundException {
		employeeService.createOrUpdateEmployee(employee);
	}

	@Test
	public void two() {

	}

	@Test
	public void three() {

	}

	@Test
	public void four() {

	}

}
