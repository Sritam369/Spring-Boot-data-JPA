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
@Table(name="Student_jpa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "JSID_SEQUENCE1",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator="gen1" , strategy=GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String course;
	@NonNull
	private Double marks;
	@NonNull
	private String grade;
	@NonNull
	private String city;
	@NonNull
	private Boolean passed;
	
}
