package com.tupid.candidateManager.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tupid.candidateManager.dto.CandidateDTO;
import com.tupid.candidateManager.exception.TupidException;
import com.tupid.candidateManager.service.CandidateService;

@RestController
@RequestMapping(value = "/infybank")
public class CandidateAPI {

	@Autowired
	private CandidateService candidateService;

	@Autowired
	private Environment environment;

	@GetMapping(value = "/candidate")
	public ResponseEntity<List<CandidateDTO>> getAllCandidates() throws TupidException {
		List<CandidateDTO> candidateList = candidateService.getAllCandidates();
		return new ResponseEntity<>(candidateList, HttpStatus.OK);
	}

	@GetMapping(value = "/candidate/{candidateName}")
	public ResponseEntity<CandidateDTO> getCustomer(@PathVariable Integer candidateName) throws TupidException {
		CandidateDTO candidate = candidateService.getCandidates(candidateName);
		return new ResponseEntity<>(candidate, HttpStatus.OK);
	}

	
	@PostMapping(value = "/candidates")
	public ResponseEntity<String> addCustomer(@RequestBody CandidateDTO candidate) throws TupidException {
		String Name = candidateService.addCandidate(candidate);
		String successMessage = environment.getProperty("API.INSERT_SUCCESS") + Name;
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@PutMapping(value = "/candidateName/{candidateName}")
	public ResponseEntity<String> updateCustomer(@RequestBody CandidateDTO customer) throws TupidException {
		candidateService.updateCandidate(customer);

		return new ResponseEntity<>("Candidate Updated successfully", HttpStatus.OK);
	}


	@DeleteMapping(value = "/candidates/{candidateName}")
	public ResponseEntity<String> deleteCustomer(@PathVariable String candidateName) throws TupidException {
		candidateService.deleteCandidate(candidateName);
		String successMessage = environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}
