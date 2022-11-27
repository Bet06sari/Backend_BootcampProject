package com.kodlamaio.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlamaio.bootcampProject.entities.users.Applicant;

@Repository
public interface ApplicantReposities extends JpaRepository<Applicant, Integer>{
	Applicant findApplicantByNationalIdentity (String nationalIdentity);
	Applicant findById(int id);
	
	
}
