package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="Student_OneToMany_mapping")
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;
	@NonNull
	private String studentName;
	@NonNull
	private String email;
	@NonNull
	private String grade;
	@ManyToOne
	@JoinColumn(name="Course_id",referencedColumnName = "courseId")
	private Course course;
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", email=" + email + ", grade="
				+ grade + "]";
	}
	
	
}
