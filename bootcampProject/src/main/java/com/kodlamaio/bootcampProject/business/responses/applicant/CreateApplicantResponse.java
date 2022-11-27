package com.kodlamaio.bootcampProject.business.responses.applicant;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicantResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String about;
}
