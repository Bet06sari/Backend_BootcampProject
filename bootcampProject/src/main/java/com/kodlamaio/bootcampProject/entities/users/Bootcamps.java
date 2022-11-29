package com.kodlamaio.bootcampProject.entities.users;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bootcamps")
public class Bootcamps {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	@Column (name = "name")
	private String name;
	@Column (name = "dateStart")
	private Date dateStart;
	@Column (name = "dateEnd")
	private Date dateEnd;
	@Column (name = "state")
	private int state;
	//state: application open : application used
	
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@OneToMany(mappedBy = "bootcamp")
	private List<Applications> application;	

}
