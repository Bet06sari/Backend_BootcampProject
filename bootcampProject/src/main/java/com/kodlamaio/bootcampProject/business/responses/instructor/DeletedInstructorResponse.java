package com.kodlamaio.bootcampProject.business.responses.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedInstructorResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private String companyName;

}
