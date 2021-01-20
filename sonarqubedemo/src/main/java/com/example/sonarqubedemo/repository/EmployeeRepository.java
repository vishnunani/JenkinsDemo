package com.example.sonarqubedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sonarqubedemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee findByLastName(String lastName);

	List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	List<Employee> anyName(String firstName);

	@Query("select e from Employee e where e.firstName like %?1")
	List<Employee> findByFirstNameEndsWith(String lastName);
	
	

}
