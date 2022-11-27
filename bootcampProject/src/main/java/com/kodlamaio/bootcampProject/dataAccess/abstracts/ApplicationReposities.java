package com.kodlamaio.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.users.Applications;

public interface ApplicationReposities extends JpaRepository<Applications, Integer>{
	Applications findById(int id);
}
