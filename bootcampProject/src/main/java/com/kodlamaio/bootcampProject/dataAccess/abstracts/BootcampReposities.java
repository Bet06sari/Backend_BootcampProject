package com.kodlamaio.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.users.Bootcamps;

public interface BootcampReposities extends JpaRepository<Bootcamps, Integer>{
	Bootcamps findById(int id);
}
