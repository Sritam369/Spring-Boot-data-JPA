package com.sri.entity;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="employee_collection_mapping")
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NonNull
	private String name;
	@ElementCollection
	@CollectionTable(name="emp_skills",joinColumns = @JoinColumn(name="skill",referencedColumnName = "id"))
	private List<String>skills;
}
