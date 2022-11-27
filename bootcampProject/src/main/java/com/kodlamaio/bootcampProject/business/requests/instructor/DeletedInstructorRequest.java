package com.kodlamaio.bootcampProject.business.requests.instructor;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedInstructorRequest {
	@NotNull(message = "this field is required")
	private int id;

}
