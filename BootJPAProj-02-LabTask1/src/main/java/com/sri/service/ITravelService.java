package com.sri.service;

import java.util.Optional;

import com.sri.entity.Travel;

public interface ITravelService {
void addTravel(Travel travel);
Iterable<Travel> getAllTravel();
Optional<Travel> findTravelById(Long id);
}
