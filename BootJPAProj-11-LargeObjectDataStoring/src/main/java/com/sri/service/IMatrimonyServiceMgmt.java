package com.sri.service;

import java.util.Optional;

import com.sri.entity.MarriageSeeker;

public interface IMatrimonyServiceMgmt {

	String registerMarriageSeeker(MarriageSeeker seeker);
	Optional<MarriageSeeker> searchSeekerById(Long id);
}
