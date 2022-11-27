package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetAllApplicationResponses;
import com.kodlamaio.bootcampProject.business.responses.application.GetApplicationResponses;
import com.kodlamaio.bootcampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface ApplicationService {
	Result delete(int id);
	DataResult<CreateApplicationResponse> Add(CreateApplicationRequest createdApplicationRequest);
	DataResult<List<GetAllApplicationResponses>> GetAll();
	DataResult<UpdateApplicationResponse> Update (UpdateApplicationRequest updateApplicationRequest);
	DataResult<GetApplicationResponses> getById(int id);
	
	
	
}
