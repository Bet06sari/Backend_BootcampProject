package com.kodlamaio.bootcampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetAllInstructorResponses;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetInstroctorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

public interface InstructorService {
	// hocanın yaptığı işlemler ->> Result işlemi ile hem success hem error
	// dönebiliyoruz
	Result delete(int id);

	DataResult<CreateInstructorResponse> Add(CreateInstructorRequest createInstructorRequest);

	DataResult<List<GetAllInstructorResponses>> GetAll();

	DataResult<UpdateInstructorResponse> Update(UpdateInstructorRequest updateInstructorRequest);

	DataResult<GetInstroctorResponse> getById(int id);
}
