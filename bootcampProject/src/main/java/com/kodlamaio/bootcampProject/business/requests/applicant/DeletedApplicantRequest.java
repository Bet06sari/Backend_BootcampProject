package com.kodlamaio.bootcampProject.business.requests.applicant;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedApplicantRequest {
	@NotNull(message = "this blank can not be blank")
	private int id;
}