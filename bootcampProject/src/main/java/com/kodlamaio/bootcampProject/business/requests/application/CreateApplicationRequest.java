package com.kodlamaio.bootcampProject.business.requests.application;

import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateApplicationRequest {
	@Min(value = 1, message = "this field cannot be left blank ")
	private int applicantId;
	@Min(value = 1, message = "this field cannot be left blank ")
	private int bootcampId;
	@Min(value = 1, message = "this field cannot be left blank ")
	private int state;
}
