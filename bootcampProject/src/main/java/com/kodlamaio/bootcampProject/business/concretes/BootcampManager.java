package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetAllBootcampResponses;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetBootcampResponses;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.BootcampReposities;
import com.kodlamaio.bootcampProject.entities.users.Bootcamps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BootcampManager implements BootcampService{
	private BootcampReposities bootcampReposities;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfBootcampExistById(id);
		this.bootcampReposities.findById(id);
		return new SuccessResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<CreateBootcampResponse> Add(CreateBootcampRequest createdBootcampRequest) {
		Bootcamps bootcamp = this.modelMapperService.forRequest().map(createdBootcampRequest, Bootcamps.class);
		this.bootcampReposities.save(bootcamp);
		
		CreateBootcampResponse createBootcampResponse = this.modelMapperService.forResponse().map(bootcamp, CreateBootcampResponse.class);
		
		return new SuccessDataResult<CreateBootcampResponse>(createBootcampResponse, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<List<GetAllBootcampResponses>> GetAll() {
		List<Bootcamps> bootcamps = this.bootcampReposities.findAll();
		List<GetAllBootcampResponses> response = bootcamps.stream().
				map(bootcamp -> this.modelMapperService.forResponse().
						map(bootcamps, GetAllBootcampResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampResponses>>(response);
	}

	@Override
	public DataResult<UpdateBootcampResponse> Update(UpdateBootcampRequest updateBootcampRequest) {
		checkIfBootcampExistById(updateBootcampRequest.getId());
		Bootcamps bootcamp = this.modelMapperService.forRequest().map(updateBootcampRequest,Bootcamps.class);
		this.bootcampReposities.save(bootcamp);
		UpdateBootcampResponse updateBootcampResponse = this.modelMapperService.forResponse().map(bootcamp, UpdateBootcampResponse.class);
		
		return new SuccessDataResult<UpdateBootcampResponse>(updateBootcampResponse, Messages.BootcampUpdated);
	}

	@Override
	public DataResult<GetBootcampResponses> getById(int id) {
		Bootcamps bootcamp = this.bootcampReposities.findById(id);
		GetBootcampResponses response = this.modelMapperService.forResponse().map(bootcamp, GetBootcampResponses.class);
		return new SuccessDataResult<GetBootcampResponses>(response);
	}
	
	
	private void checkIfBootcampExistById(int id) 
	{
		if(bootcampReposities.findById(id) ==null)
			throw new BusinessException(Messages.BootcampExists);
	}

}
