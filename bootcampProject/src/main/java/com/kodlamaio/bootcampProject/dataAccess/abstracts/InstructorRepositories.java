package com.kodlamaio.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.users.Instructor;

public interface InstructorRepositories extends JpaRepository<Instructor, Integer>{
	Instructor findInstructorByNationalIdentity (String nationalIdentity);
	Instructor findById(int id);
}
