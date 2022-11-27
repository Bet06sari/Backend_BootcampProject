package com.kodlamaio.bootcampProject.business.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedEmployeeResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String password;
	private String position;
}
