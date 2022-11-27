package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.employee.GetAllEmployeeResponses;
import com.kodlamaio.bootcampProject.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface EmployeeService {

	Result delete(int id);

	DataResult<CreateEmployeeResponse> Add(CreateEmployeeRequest createEmployeeRequest);

	DataResult<List<GetAllEmployeeResponses>> GetAll();

	DataResult<UpdateEmployeeResponse> Update(UpdateEmployeeRequest updateEmployeeRequest);

	DataResult<GetEmployeeResponse> getById(int id);
}
