package com.kodlamaio.bootcampProject.business.responses.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeeResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private String position;
}
