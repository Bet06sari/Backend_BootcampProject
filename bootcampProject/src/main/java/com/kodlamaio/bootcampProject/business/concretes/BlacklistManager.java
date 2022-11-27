package com.kodlamaio.bootcampProject.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootcampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootcampProject.business.abstracts.BlacklistService;
import com.kodlamaio.bootcampProject.business.constants.Messages;
import com.kodlamaio.bootcampProject.business.requests.blacklist.CreateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.requests.blacklist.UpdateBlacklistRequest;
import com.kodlamaio.bootcampProject.business.responses.blacklist.CreateBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklist.GetAllBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklist.GetBlacklistResponse;
import com.kodlamaio.bootcampProject.business.responses.blacklist.UpdateBlacklistResponse;
import com.kodlamaio.bootcampProject.core.utilities.exceptions.BusinessException;
import com.kodlamaio.bootcampProject.core.utilities.mapping.ModelMapperService;
import com.kodlamaio.bootcampProject.core.utilities.results.DataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.Result;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessDataResult;
import com.kodlamaio.bootcampProject.core.utilities.results.SuccessResult;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.ApplicationReposities;
import com.kodlamaio.bootcampProject.dataAccess.abstracts.BlacklistRepositories;
import com.kodlamaio.bootcampProject.entities.users.Blacklist;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BlacklistManager implements BlacklistService {
	private BlacklistRepositories blacklistRepositories;
	private ApplicationReposities applicationReposities;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;

	@Override
	public Result delete(int id) {
		checkIfBlacklistExistById(id);
		this.blacklistRepositories.deleteById(id);
		return new SuccessResult(Messages.BlacklistDeleted);
	}

	@Override
	public DataResult<CreateBlacklistResponse> add(CreateBlacklistRequest createBlacklistRequest) {
		//checkIfApplicantIsInBlacklist(createBlacklistRequest.getApplicantId());
		applicantService.checkIfUserIsApplicant(createBlacklistRequest.getApplicantId());
		Blacklist blacklist = this.modelMapperService.forRequest().map(createBlacklistRequest, Blacklist.class);
		this.blacklistRepositories.save(blacklist);

		CreateBlacklistResponse createBlacklistResponse = this.modelMapperService.forResponse().map(blacklist,
				CreateBlacklistResponse.class);
		return new SuccessDataResult<>(createBlacklistResponse, Messages.BlacklistCreated);
	}

	@Override
	public DataResult<List<GetAllBlacklistResponse>> getAll() {
		List<Blacklist> blacklist = this.blacklistRepositories.findAll();
		List<GetAllBlacklistResponse> response = blacklist.stream()
				.map(blacklists -> this.modelMapperService.forResponse().map(blacklists, GetAllBlacklistResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBlacklistResponse>>(response);
	}

	@Override
	public DataResult<UpdateBlacklistResponse> Update(UpdateBlacklistRequest updateBlacklistRequest) {
		checkIfBlacklistExistById(updateBlacklistRequest.getId());
		Blacklist blacklist = this.modelMapperService.forRequest().map(updateBlacklistRequest, Blacklist.class);
		this.blacklistRepositories.save(blacklist);
		UpdateBlacklistResponse updateBlacklistResponse = this.modelMapperService.forResponse().map(blacklist,
				UpdateBlacklistResponse.class);
		return new SuccessDataResult<>(updateBlacklistResponse, Messages.BlacklistUpdated);
	}

	@Override
	public DataResult<GetBlacklistResponse> getById(int id) {
		Blacklist blacklist = this.blacklistRepositories.findById(id).orElse(null);
		GetBlacklistResponse response = this.modelMapperService.forResponse().map(blacklist,
				GetBlacklistResponse.class);
		return new SuccessDataResult<>(response);
	}

	private void checkIfBlacklistExistById(int id) {
		if (!blacklistRepositories.existsById(id)) {
			applicationReposities.deleteById(id);
			throw new BusinessException(Messages.BlacklistNotExists);
		}
	}

	@Override
	public void checkIfApplicantIsInBlacklist(int applicantId) {
		if (blacklistRepositories.existsBlacklistByApplicantId(applicantId)) {
			throw new BusinessException(Messages.ApplicantIsInBlackList);
		}

	}

}
