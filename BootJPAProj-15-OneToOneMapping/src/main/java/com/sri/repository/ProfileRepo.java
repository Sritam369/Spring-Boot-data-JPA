package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Profile;

public interface ProfileRepo extends JpaRepository<Profile, Long> {

}
