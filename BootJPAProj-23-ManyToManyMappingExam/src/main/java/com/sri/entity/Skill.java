package com.sri.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="skill_exam_many")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Skill {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long sid;
	@NonNull
	private String sName;
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "skills")
	private List<Employee> emps = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Employee [id=" + sid + ", name=" + sName + "]";
	}
}
