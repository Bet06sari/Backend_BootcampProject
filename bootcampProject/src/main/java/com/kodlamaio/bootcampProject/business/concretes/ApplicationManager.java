package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampProject.business.abstracts.ApplicationService;
import com.kodlamaio.bootcampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootcampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetAllApplicationResponses;
import com.kodlamaio.bootcampProject.business.responses.application.GetApplicationResponses;
import com.kodlamaio.bootcampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.ApplicationReposities;
import com.kodlamaio.bootcampProject.entities.users.Applications;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationManager implements ApplicationService {
	private ApplicationReposities applicationReposities;
	private BlacklistService blacklistService;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfApplicationExistById(id);
		this.applicationReposities.deleteById(id);
		return new SuccessResult(Messages.ApplicationDeleted);
	}

	@Override
	public DataResult<CreateApplicationResponse> Add(CreateApplicationRequest createdApplicationRequest) {
		blacklistService.checkIfApplicantIsInBlacklist(createdApplicationRequest.getApplicantId());
		Applications application = this.modelMapperService.forRequest().map(createdApplicationRequest,
				Applications.class);
		this.applicationReposities.save(application);

		CreateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(application,
				CreateApplicationResponse.class);
		return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);
	}

	@Override
	public DataResult<List<GetAllApplicationResponses>> GetAll() {
		//checkIfApplicationExistById();
		List<Applications> applications = this.applicationReposities.findAll();
		List<GetAllApplicationResponses> response = applications.stream().map(application -> this.modelMapperService
				.forResponse().map(applications, GetAllApplicationResponses.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationResponses>>(response);
	}

	@Override
	public DataResult<UpdateApplicationResponse> Update(UpdateApplicationRequest updateApplicationRequest) {
		Applications application = this.modelMapperService.forRequest().map(updateApplicationRequest,
				Applications.class);
		this.applicationReposities.save(application);
		UpdateApplicationResponse updateApplicationResponse = this.modelMapperService.forResponse().map(application,
				UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(updateApplicationResponse, Messages.ApplicationUpdated);
	}

	@Override
	public DataResult<GetApplicationResponses> getById(int id) {
		Applications application = this.applicationReposities.findById(id);
		GetApplicationResponses response = this.modelMapperService.forResponse().map(application,
				GetApplicationResponses.class);
		return new SuccessDataResult<GetApplicationResponses>(response);
	}


	private void checkIfApplicationExistById(int id) {
		if (applicationReposities.findById(id) == null)
			throw new BusinessException(Messages.ApplicationExists);
	}


}
