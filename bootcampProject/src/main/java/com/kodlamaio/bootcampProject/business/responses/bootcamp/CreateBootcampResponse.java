package com.kodlamaio.bootcampProject.business.responses.bootcamp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBootcampResponse {
	private String name;
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	Date dateStart;
	@DateTimeFormat(pattern="dd/MM/yyyy") 
	private Date dateEnd;
	private String state;
	private int intructorId;
	
}
