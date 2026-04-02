package com.sri.entity;



import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employeejpa")
@Data
@NoArgsConstructor
public class Employeejpa {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer empId;
	@Nonnull
	@Column(name="name" , length=25)
	private String empName;
	@Nonnull
	@Column(name="dept",length=25)
	private String department;
	@Nonnull
	@Column(name="sal")
	private Double salary;
}
