package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Project;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
