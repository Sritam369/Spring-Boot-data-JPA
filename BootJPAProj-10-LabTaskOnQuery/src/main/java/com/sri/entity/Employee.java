package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="employee_lab_jpa")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy=GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String department;
	@NonNull
	private Double salary;
	@NonNull
	private String designation;
}
