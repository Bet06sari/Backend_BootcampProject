package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampProject.business.abstracts.EmployeeService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetAllApplicantResponses;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetApplicantResponses;
import com.kodlamaio.bootcampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.ApplicantReposities;
import com.kodlamaio.bootcampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicantManager implements ApplicantService {
	private ApplicantReposities applicantReposities;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfApplicantExistById(id);
		this.applicantReposities.findById(id);
		return new SuccessResult(Messages.ApplicantDeleted);
	}

	@Override
	public DataResult<CreateApplicantResponse> Add(CreateApplicantRequest createdApplicantRequest) {
		checkIfApplicantExistByNationalIdentity(createdApplicantRequest.getNationalIdentity());
		
		Applicant applicant = this.modelMapperService.forRequest().map(createdApplicantRequest, Applicant.class);
		this.applicantReposities.save(applicant);

		CreateApplicantResponse createApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(createApplicantResponse, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<List<GetAllApplicantResponses>> GetAll() {
		List<Applicant> applicants = this.applicantReposities.findAll();
		List<GetAllApplicantResponses> response = applicants.stream()
				.map(applicant -> this.modelMapperService.forResponse().map(applicants, GetAllApplicantResponses.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponses>>(response);
	}

	@Override
	public DataResult<UpdateApplicantResponse> Update(UpdateApplicantRequest updateApplicantRequest) {
		checkIfApplicantExistById(updateApplicantRequest.getId());
		Applicant applicant = this.modelMapperService.forRequest().map(updateApplicantRequest, Applicant.class);
		this.applicantReposities.save(applicant);
		UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);

		return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse, Messages.ApplicantUpdated);

	}

	@Override
	public DataResult<GetApplicantResponses> getById(int id) {
		Applicant applicant = this.applicantReposities.findById(id);
		GetApplicantResponses response = this.modelMapperService.forResponse().map(applicant,
				GetApplicantResponses.class);

		return new SuccessDataResult<GetApplicantResponses>(response);
	}

	private void checkIfApplicantExistByNationalIdentity(String nationalIdentity) {
		if (applicantReposities.findApplicantByNationalIdentity(nationalIdentity) != null)
			throw new BusinessException(Messages.ApplicantNationalIdentityExist);
	}

	private void checkIfApplicantExistById(int id) {
		if (applicantReposities.findById(id) == null)
			throw new BusinessException(Messages.ApplicantExists);
	}

	@Override
	public void checkIfUserIsApplicant(int applicantId) {
		if (!applicantReposities.existsById(applicantId)) {
			throw new BusinessException(Messages.IsNotApplicant);
		}
	}
}
