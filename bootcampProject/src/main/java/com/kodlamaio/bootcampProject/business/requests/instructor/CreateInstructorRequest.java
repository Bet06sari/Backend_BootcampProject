package com.kodlamaio.bootcampProject.business.requests.instructor;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//sadece burda id yok
public class CreateInstructorRequest {
	@NotNull(message = "this field is required")
	private String firstName;
	@NotNull(message = "this field is required")
	private String lastName;
	@NotNull(message = "this field is required")
	@Email(regexp = ".+[@].+[\\.].+", message = "Email must be valid")
	private String eMail;
	@NotNull(message = "this field is required")
	private String password;
	@NotNull(message = "this field is required")
	private String companyName;
	@NotNull(message = "this field is required")
	@Size(min = 11 , max = 11 , message = "National identity has the size of 11")
	private String nationalIdentity;
	@NotNull(message = "this field is required")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dateOfBirth;

}
