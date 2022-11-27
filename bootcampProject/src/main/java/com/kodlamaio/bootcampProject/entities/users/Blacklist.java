package com.kodlamaio.bootcampProject.entities.users;

import java.time.LocalDate;

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
@Table(name="blacklist")
public class Blacklist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="reason")
	private String reason;
	@Column(name="date")
	private LocalDate date;
	
	@ManyToOne()
	@JoinColumn(name="applicant_id")
	private Applicant applicant;
	
}
