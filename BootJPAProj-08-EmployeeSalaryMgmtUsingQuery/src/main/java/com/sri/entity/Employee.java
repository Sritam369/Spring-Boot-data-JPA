package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="employee_data")
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1", strategy=GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String dept;
	@NonNull
	private Double sal;
	@NonNull
	private Integer exp;
}
