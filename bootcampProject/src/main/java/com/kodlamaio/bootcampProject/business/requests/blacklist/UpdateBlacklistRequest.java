package com.kodlamaio.bootcampProject.business.requests.blacklist;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {
	@NotNull(message = "this blank can not be blank")
	private int id;
	@NotNull(message = "this blank can not be blank")
	private int applicantId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@NotNull(message = "this blank can not be blank")
	private LocalDate date;
	@NotNull(message = "this blank can not be blank")
	private String reason;
}
