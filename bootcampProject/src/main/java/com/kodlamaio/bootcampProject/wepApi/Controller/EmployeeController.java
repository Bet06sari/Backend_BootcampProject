package com.kodlamaio.bootcampProject.wepApi.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootcampProject.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.employee.GetAllEmployeeResponses;
import com.kodlamaio.bootcampProject.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@GetMapping("/{id}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int id) {
		return this.employeeService.getById(id);
	}
	
	@GetMapping
	public DataResult<List<GetAllEmployeeResponses>> GetAll() {
		return this.employeeService.GetAll();
	}
	
	@PostMapping
	public DataResult<CreateEmployeeResponse> Add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return this.employeeService.Add(createEmployeeRequest);
	}
	
	@PutMapping
	public DataResult<UpdateEmployeeResponse> Update (@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
		return this.employeeService.Update(updateEmployeeRequest);
		
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.employeeService.delete(id);
	}
	
}
