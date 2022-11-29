package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.applicant.CreateApplicantRequest;
import com.kodlamaio.bootcampProject.business.requests.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootcampProject.business.responses.applicant.CreateApplicantResponse;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetAllApplicantResponses;
import com.kodlamaio.bootcampProject.business.responses.applicant.GetApplicantResponses;
import com.kodlamaio.bootcampProject.business.responses.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicantService {
	Result delete(int id);
	DataResult<CreateApplicantResponse> Add(CreateApplicantRequest createdApplicantRequest);
	DataResult<List<GetAllApplicantResponses>> GetAll();
	DataResult<UpdateApplicantResponse> Update (UpdateApplicantRequest updateApplicantRequest);
	DataResult<GetApplicantResponses> getById(int id);
	
	void checkIfUserIsApplicant(int applicantId);
	
}
