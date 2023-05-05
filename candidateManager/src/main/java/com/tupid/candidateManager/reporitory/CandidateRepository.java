package com.tupid.candidateManager.reporitory;


import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tupid.candidateManager.entity.Candidate;

public interface CandidateRepository extends PagingAndSortingRepository<Candidate, Integer> {

	Optional<Candidate> findByName(String name,PageRequest firstPageWithTenElements);


	void deleteByName(String name);

}
