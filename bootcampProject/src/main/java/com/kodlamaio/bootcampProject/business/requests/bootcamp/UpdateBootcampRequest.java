package com.kodlamaio.bootcampProject.business.requests.bootcamp;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBootcampRequest {
	@NotNull(message = "this field is required")
	private int id;
	@NotNull(message = "this field is required")
	private int intructorId;
	@NotNull(message = "this field is required")
	private String name;
	@NotNull(message = "this field is required")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy") 
	Date dateStart;
	@NotNull(message = "this field is required")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd/MM/yyyy") 
	private Date dateEnd;
	@NotNull(message = "this field is required")
	private int state;
}
