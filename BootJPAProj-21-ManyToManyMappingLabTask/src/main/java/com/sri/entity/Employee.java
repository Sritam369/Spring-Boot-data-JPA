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
@Table(name="Emp_ManyToMany")
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long eid;
	@NonNull
	private String empName;
	@NonNull
	private String department;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ManyToMany",joinColumns = @JoinColumn(name="emp_id",referencedColumnName = "eid"),inverseJoinColumns = @JoinColumn(name="project_id",referencedColumnName = "pid"))
	private List<Project> projects;
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", empName=" + empName + ", department=" + department + "]";
	}
	
	
}
