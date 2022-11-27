package com.kodlamaio.bootcampProject.business.responses.instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateInstructorResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
//password silmemiz lazım
	private String companyName;

}
