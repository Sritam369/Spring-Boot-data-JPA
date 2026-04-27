package com.sri.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Emp_ManyToMany_labtask1")
@NoArgsConstructor
@RequiredArgsConstructor
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long pid;
	@NonNull
	private String projName;
	@ManyToMany(mappedBy="projects")
	private List<Employee> emps;
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", projName=" + projName + "]";
	}
	
}
