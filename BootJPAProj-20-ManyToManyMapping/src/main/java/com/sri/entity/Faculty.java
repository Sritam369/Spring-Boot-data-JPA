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
@Table(name="faculty_ManyToMany")
@NoArgsConstructor
@RequiredArgsConstructor
public class Faculty {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "se",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
	private Integer fid;
	@NonNull
	private String fName;
	@NonNull
	private String fAddrs;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="faculty_student_fk",joinColumns = @JoinColumn(name="faculty_id",referencedColumnName = "fid"), inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName = "sid"))
	private Set<Student> studentInfo = new HashSet<>();
	
	@Override
	public String toString() {
		return "Faculty [fid=" + fid + ", fName=" + fName + ", fAddrs=" + fAddrs + "]";
	}
	
	
	
	
}
