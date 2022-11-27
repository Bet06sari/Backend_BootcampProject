package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.employee.CreateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.requests.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootcampProject.business.responses.employee.CreateEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.employee.GetAllEmployeeResponses;
import com.kodlamaio.bootcampProject.business.responses.employee.GetEmployeeResponse;
import com.kodlamaio.bootcampProject.business.responses.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.EmployeeRepositories;
import com.kodlamaio.bootcampProject.entities.users.Employee;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {
	private EmployeeRepositories employeeRepositories;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfEmployeeExistById(id);
		this.employeeRepositories.deleteById(id);
		return new SuccessResult(Messages.EmployeeDeleted);
	}

	@Override
	public DataResult<CreateEmployeeResponse> Add(CreateEmployeeRequest createEmployeeRequest) {
		checkIfEmployeeExistByNationalIdentity(createEmployeeRequest.getNationalIdentity());
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepositories.save(employee);
		CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);
		return new SuccessDataResult<CreateEmployeeResponse>(createEmployeeResponse, Messages.EmployeeCreated);
	}

	@Override
	public DataResult<List<GetAllEmployeeResponses>> GetAll() {
		List<Employee> employees = this.employeeRepositories.findAll();
		List<GetAllEmployeeResponses> response = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employees, GetAllEmployeeResponses.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeeResponses>>(response);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> Update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfEmployeeExistById(updateEmployeeRequest.getId());
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepositories.save(employee);
		UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);

		return new SuccessDataResult<UpdateEmployeeResponse>(updateEmployeeResponse, Messages.EmployeeUpdated);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		Employee employee = this.employeeRepositories.findById(id);
		GetEmployeeResponse response = this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);

		return new SuccessDataResult<GetEmployeeResponse>(response);
	}

	private void checkIfEmployeeExistByNationalIdentity(String nationalIdentity) {
		if (employeeRepositories.findEmployeeByNationalIdentity(nationalIdentity) !=null)
			throw new BusinessException(Messages.EmployeeNationalIdentityExist);
	}

	private void checkIfEmployeeExistById(int id) {
		if (employeeRepositories.findById(id) == null) {
			throw new BusinessException(Messages.EmployeeExists);
		}
	}

}
