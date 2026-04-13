package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.sri.entity.MarriageSeeker;

public interface MarriageRepo extends JpaRepository<MarriageSeeker, Long>{

}
