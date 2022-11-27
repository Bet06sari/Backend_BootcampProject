package com.kodlamaio.bootcampProject.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {
	
	@Column(name = "position")
	private String position;
	
}
