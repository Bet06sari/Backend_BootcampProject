package com.kodlamaio.bootcampProject.entities.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@NotNull
	@Column(name = "firstName")
	private String firstName;
	@NotNull
	@Column(name = "lastName")
	private String lastName;
	@NotNull
	@Column(name = "eMail")
	private String eMail;
	@NotNull
	@Column(name = "password")
	private String password;
	@NotNull
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	@NotNull
	@Column(name = "nationalIdentity")
	private String nationalIdentity;
		
}
