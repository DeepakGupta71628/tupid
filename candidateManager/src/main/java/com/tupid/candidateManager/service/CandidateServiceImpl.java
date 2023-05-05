package com.tupid.candidateManager.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tupid.candidateManager.dto.CandidateDTO;
import com.tupid.candidateManager.entity.Candidate;
import com.tupid.candidateManager.exception.TupidException;
import com.tupid.candidateManager.reporitory.CandidateRepository;




@Service(value = "candidateService")
@Transactional
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	
	PageRequest firstPageWithTenElements = PageRequest.of(0,10 );

	PageRequest secondPageWithFiveElements = PageRequest.of(1, 5);
	PageRequest sortedByName = PageRequest.of(0, 3, Sort.by("name"));

	@Override
	public CandidateDTO getCandidates(Integer customerId) throws TupidException {
		Optional<Candidate> optional = candidateRepository.findById(customerId);
		Candidate candidate = optional.orElseThrow(() -> new TupidException("Candidate Not Found"));
		
		CandidateDTO candidate2 = new CandidateDTO();
		candidate2.setAddress(candidate.getAddress());
		candidate2.setEmail(candidate.getEmail());
		candidate2.setName(candidate.getName());
		candidate2.setPhoneNumber(candidate.getPhoneNumber());
		return candidate2;
	}

	@Override
	public List<CandidateDTO> getAllCandidates() throws TupidException {
		Iterable<Candidate> candidates = candidateRepository.findAll(sortedByName);
		
		List<CandidateDTO> cans = new ArrayList<>();
		candidates.forEach(candidate -> {
			CandidateDTO candidate2 = new CandidateDTO();
			candidate2.setAddress(candidate.getAddress());
			candidate2.setEmail(candidate.getEmail());
			candidate2.setName(candidate.getName());
			candidate2.setPhoneNumber(candidate.getPhoneNumber());
			cans.add(candidate2);
		});
		if (cans.isEmpty())
			throw new TupidException("Candidates Not Found");
		return cans;
	}

	@Override
	public String addCandidate(CandidateDTO candidate) throws TupidException {
		Candidate candidate2 = new Candidate();
		
		candidate2.setAddress(candidate.getAddress());
		candidate2.setEmail(candidate.getEmail());
		candidate2.setName(candidate.getName());
		candidate2.setPhoneNumber(candidate.getPhoneNumber());
		
		Candidate customerEntity2 = candidateRepository.save(candidate2);
		
		return customerEntity2.getName();
	}

	
	@Override
	public void updateCandidate(CandidateDTO candidate) throws TupidException {
		Optional<Candidate> optionl = candidateRepository.findByName(candidate.getName(),firstPageWithTenElements);
		Candidate candidate2 = optionl.orElseThrow(() -> new TupidException("Candidate Not Found"));
		

		
		candidate2.setAddress(candidate.getAddress());
		candidate2.setEmail(candidate.getEmail());
		candidate2.setName(candidate.getName());
		candidate2.setPhoneNumber(candidate.getPhoneNumber());
		
		candidateRepository.save(candidate2);
	}

	@Override
	public void deleteCandidate(String name) throws TupidException {
		Optional<Candidate> optionl = candidateRepository.findByName(name,sortedByName);
		optionl.orElseThrow(() -> new TupidException("Candidate Not Found"));
		candidateRepository.deleteByName(name);
	}



}
