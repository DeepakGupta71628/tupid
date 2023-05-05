package com.tupid.candidateManager.service;

import java.util.List;
import com.tupid.candidateManager.dto.CandidateDTO;
import com.tupid.candidateManager.exception.TupidException;

public interface CandidateService {
	public CandidateDTO getCandidates(Integer customerId) throws TupidException;
	public List<CandidateDTO> getAllCandidates() throws TupidException;
	public String addCandidate(CandidateDTO candidate) throws TupidException;
	public void updateCandidate(CandidateDTO candidate) throws TupidException;
	public void deleteCandidate(String name) throws TupidException;
}
