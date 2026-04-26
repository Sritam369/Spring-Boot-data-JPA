package com.sri.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="Course_OneToMany")
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long courseId;
	@NonNull
	private String courseName;
	@NonNull
	private String duration;
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "course")
	private List<Student> studs;
}
