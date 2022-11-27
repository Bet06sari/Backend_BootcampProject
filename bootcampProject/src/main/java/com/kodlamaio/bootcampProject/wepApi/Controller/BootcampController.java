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

import com.kodlamaio.bootcampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootcampProject.business.requests.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetAllBootcampResponses;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.GetBootcampResponses;
import com.kodlamaio.bootcampProject.business.responses.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bootcamps")
public class BootcampController {
	private BootcampService bootcampService;
	
	@GetMapping("/{id}")
	public DataResult<GetBootcampResponses> getById(@PathVariable int id) {
		return this.bootcampService.getById(id);
	}
	
	@GetMapping
	public DataResult<List<GetAllBootcampResponses>> GetAll() {
		return this.bootcampService.GetAll();
	}
	
	@PostMapping
	public DataResult<CreateBootcampResponse> Add(@RequestBody CreateBootcampRequest createBootcampRequest) {
		return this.bootcampService.Add(createBootcampRequest);
	}
	
	@PutMapping
	public DataResult<UpdateBootcampResponse> Update (@RequestBody UpdateBootcampRequest updateBootcampRequest){
		return this.bootcampService.Update(updateBootcampRequest);
		
	}
	
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.bootcampService.delete(id);

	}
}
