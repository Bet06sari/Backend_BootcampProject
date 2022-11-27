package com.kodlamaio.bootcampProject.entities.users;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="applications")
public class Applications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "applicant_id")
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name = "bootcamp_id")
	private Bootcamps bootcamp;
	@Column(name = "state")
	private int state;

}
