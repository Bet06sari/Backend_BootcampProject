package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetAllBootcampResponses;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetBootcampResponses;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface BootcampService {
	Result delete(int id);
	DataResult<CreateBootcampResponse> Add(CreateBootcampRequest createdBootcampRequest);
	DataResult<List<GetAllBootcampResponses>> GetAll();
	DataResult<UpdateBootcampResponse> Update (UpdateBootcampRequest updateBootcampRequest);
	DataResult<GetBootcampResponses> getById(int id);
}
