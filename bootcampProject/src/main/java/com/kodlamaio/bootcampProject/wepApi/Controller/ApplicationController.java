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

import com.kodlamaio.bootcampProject.business.abstracts.ApplicationService;
import com.kodlamaio.bootcampProject.business.requests.application.CreateApplicationRequest;
import com.kodlamaio.bootcampProject.business.requests.application.UpdateApplicationRequest;
import com.kodlamaio.bootcampProject.business.responses.application.CreateApplicationResponse;
import com.kodlamaio.bootcampProject.business.responses.application.GetAllApplicationResponses;
import com.kodlamaio.bootcampProject.business.responses.application.GetApplicationResponses;
import com.kodlamaio.bootcampProject.business.responses.application.UpdateApplicationResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/applications")
public class ApplicationController {
	private ApplicationService applicationService;
	@GetMapping("/{id}")
	public DataResult<GetApplicationResponses> getById(@PathVariable int id) {
		return this.applicationService.getById(id);
	}
	
	@GetMapping
	public DataResult<List<GetAllApplicationResponses>> GetAll() {
		return this.applicationService.GetAll();
	}
	
	@PostMapping
	public DataResult<CreateApplicationResponse> Add(@RequestBody CreateApplicationRequest createApplicationRequest) {
		return this.applicationService.Add(createApplicationRequest);
	}
	
	@PutMapping
	public DataResult<UpdateApplicationResponse> Update (@RequestBody UpdateApplicationRequest updateApplicationRequest){
		return this.applicationService.Update(updateApplicationRequest);
		
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicationService.delete(id);
	}

}
