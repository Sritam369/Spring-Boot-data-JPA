package com.sri.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="student_ManyToMany")
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "se",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
	private Integer sid;
	@NonNull
	private String sName;
	@NonNull
	private String sAddrs;
	@NonNull
	private String college;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="studentInfo")
	private Set<Faculty> facultyInfo = new HashSet<>();
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sAddrs=" + sAddrs + ", college=" + college + "]";
	}
	
	
	
	
}
