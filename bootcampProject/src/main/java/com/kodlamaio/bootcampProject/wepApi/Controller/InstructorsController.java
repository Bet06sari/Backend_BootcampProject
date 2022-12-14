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

import com.kodlamaio.bootcampProject.business.abstracts.InstructorService;
import com.kodlamaio.bootcampProject.business.requests.instructor.CreateInstructorRequest;
import com.kodlamaio.bootcampProject.business.requests.instructor.UpdateInstructorRequest;
import com.kodlamaio.bootcampProject.business.responses.instructor.CreateInstructorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetAllInstructorResponses;
import com.kodlamaio.bootcampProject.business.responses.instructor.GetInstroctorResponse;
import com.kodlamaio.bootcampProject.business.responses.instructor.UpdateInstructorResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/instructors")

//controller her zaman çoğul yazılır.
public class InstructorsController {
	private InstructorService instructorService;

	@GetMapping("/{id}")
	public DataResult<GetInstroctorResponse> getById(@PathVariable int id) {
		return this.instructorService.getById(id);
	}

	@GetMapping
	public DataResult<List<GetAllInstructorResponses>> GetAll() {
		return this.instructorService.GetAll();
	}

	@PostMapping()
	public DataResult<CreateInstructorResponse> Add(@RequestBody CreateInstructorRequest createInstructorRequest) {
		return this.instructorService.Add(createInstructorRequest);
	}

	@PutMapping()
	public DataResult<UpdateInstructorResponse> Update(@RequestBody UpdateInstructorRequest updateInstructorRequest) {
		return this.instructorService.Update(updateInstructorRequest);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.instructorService.delete(id);
	}

}
