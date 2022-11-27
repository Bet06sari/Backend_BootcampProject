package com.kodlamaio.bootcampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "applicants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {
	
	@Column(name = "about")
	private String about;
	
	@OneToMany(mappedBy = "applicant")
	private List<Blacklist> blacklist;
	
	@OneToMany(mappedBy = "applicant")
	private List<Applications> applications;
}
