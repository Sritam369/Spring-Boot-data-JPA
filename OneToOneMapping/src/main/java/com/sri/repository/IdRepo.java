package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.IdCard;

public interface IdRepo extends JpaRepository<IdCard, Long> {

}
