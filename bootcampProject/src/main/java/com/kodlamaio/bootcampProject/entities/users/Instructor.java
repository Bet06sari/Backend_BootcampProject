package com.kodlamaio.bootcampProject.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "instructor")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends User {
		
	@Column(name = "companyName")
	private String companyName;
	
}
