package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.CallerTuneInfo;

public interface CallerTuneRepo extends JpaRepository<CallerTuneInfo, Integer> {

}
