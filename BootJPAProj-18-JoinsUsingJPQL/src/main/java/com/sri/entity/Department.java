package com.sri.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="dept_Joins")
public class Department {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s3",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String location;
	@OneToMany(targetEntity = Employee.class,cascade = CascadeType.ALL,mappedBy="dept",fetch = FetchType.EAGER)
	private List<Employee> emps;
}
