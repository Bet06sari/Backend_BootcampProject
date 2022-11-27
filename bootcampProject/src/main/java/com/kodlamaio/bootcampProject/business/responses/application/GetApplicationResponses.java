package com.kodlamaio.bootcampProject.business.responses.application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetApplicationResponses {
	private int applicantId;
	private int bootcampId;
	private int state;
}
