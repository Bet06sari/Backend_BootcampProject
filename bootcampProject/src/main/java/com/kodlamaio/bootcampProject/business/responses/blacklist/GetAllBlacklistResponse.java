package com.kodlamaio.bootcampProject.business.responses.blacklist;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBlacklistResponse {
	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;
}
