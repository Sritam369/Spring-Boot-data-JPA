package com.sri.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sri.entity.Travel;
import com.sri.repository.TravelRepository;

@Service
public class TravelService implements ITravelService {
	
	@Autowired
	private TravelRepository repo;

	@Override
	public void addTravel(Travel travel) {
		Travel t = repo.save(travel);
	}

	@Override
	public Iterable<Travel> getAllTravel() {
		Iterable<Travel> all = repo.findAll();
		return all;
	}

	@Override
	public Optional<Travel> findTravelById(Long id) {
		Optional<Travel> byId = repo.findById(id);
		return byId;
	}

}
