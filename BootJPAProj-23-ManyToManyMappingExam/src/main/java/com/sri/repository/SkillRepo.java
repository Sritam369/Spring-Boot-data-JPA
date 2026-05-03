package com.sri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.Skill;

public interface SkillRepo extends JpaRepository<Skill, Long> {

}
