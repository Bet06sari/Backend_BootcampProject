package com.kodlamaio.bootcampProject.business.requests.applicant;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicantRequest {
	@NotNull(message = "this field is required")
	private String firstName;
	@NotNull(message = "this field is required")
	private String lastName;
	@Email(regexp = ".+[@].+[\\.].+", message = "Email must be valid")
	private String eMail;
	@NotNull(message = "this field is required")
	@Pattern(regexp = "^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message = "Password must be minimum 8 characters, at least one letter, one number and one special character:")
	private String password;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@NotNull(message = "this field is required")
	private Date dateOfBirth;
	@Size(min = 11 , max = 11 , message = "National identity has the size of 11")
	@NotNull(message = "this field is required")
	private String nationalIdentity;
	@NotNull(message = "this field is required")
	private String about;
}
