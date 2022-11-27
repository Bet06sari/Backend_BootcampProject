package com.kodlamaio.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.users.Employee;

public interface EmployeeRepositories extends JpaRepository<Employee, Integer>{

	Employee findEmployeeByNationalIdentity (String nationalIdentity);
	Employee findById(int id);
}
