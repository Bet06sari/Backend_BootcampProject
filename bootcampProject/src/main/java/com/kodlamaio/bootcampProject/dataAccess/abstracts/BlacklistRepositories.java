package com.kodlamaio.bootcampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootcampProject.entities.users.Blacklist;

public interface BlacklistRepositories extends JpaRepository<Blacklist, Integer>{
	//Blacklist findById(int id);
	Blacklist findByApplicantId(int applicantId);
	boolean existsBlacklistByApplicantId(int id);
}
