package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.InstructorService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetAllInstructorResponses;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetInstroctorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.InstructorRepositories;
import com.kodlamaio.bootcampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class InstructorManager implements InstructorService {

	private InstructorRepositories instructorRepositories;
	private ModelMapperService modelMapperService;

	@Override
	public Result delete(int id) {
		checkIfInstructorExistById(id);
		this.instructorRepositories.deleteById(id);
		return new SuccessResult(Messages.InstructorDeleted);
	}

	@Override
	public DataResult<CreateInstructorResponse> Add(CreateInstructorRequest createInstructorRequest) {
		checkIfInstructorExistByNationalIdentity(createInstructorRequest.getNationalIdentity());
		Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
		this.instructorRepositories.save(instructor);

		CreateInstructorResponse createInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				CreateInstructorResponse.class);

		return new SuccessDataResult<CreateInstructorResponse>(createInstructorResponse, Messages.InstructorCreated);
	}

	@Override
	public DataResult<List<GetAllInstructorResponses>> GetAll() {
		List<Instructor> instructors = this.instructorRepositories.findAll();

		List<GetAllInstructorResponses> response = instructors.stream().map(
				instructor -> this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponses.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllInstructorResponses>>(response);
	}

	@Override
	public DataResult<UpdateInstructorResponse> Update(UpdateInstructorRequest updateInstructorRequest) {
		checkIfInstructorExistById(updateInstructorRequest.getId());
		Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);

		this.instructorRepositories.save(instructor);

		UpdateInstructorResponse updateInstructorResponse = this.modelMapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);

		return new SuccessDataResult<UpdateInstructorResponse>(updateInstructorResponse, Messages.InstructorUpdated);
	}

	@Override
	public DataResult<GetInstroctorResponse> getById(int id) {
		Instructor instructor = this.instructorRepositories.findById(id);
		GetInstroctorResponse response = this.modelMapperService.forResponse().map(instructor,
				GetInstroctorResponse.class);
		return new SuccessDataResult<GetInstroctorResponse>(response);
	}

	private void checkIfInstructorExistByNationalIdentity(String nationalIdentity) {
		if (instructorRepositories.findInstructorByNationalIdentity(nationalIdentity) != null)
			throw new BusinessException(Messages.InsturctorNationalIdentityExist);
	}

	private void checkIfInstructorExistById(int id) {
		if (instructorRepositories.findById(id) == null)
			throw new BusinessException(Messages.InsturctorExists);
	}

}
