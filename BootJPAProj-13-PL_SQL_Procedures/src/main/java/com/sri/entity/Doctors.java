package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="DOCTORS_JPA")
@NoArgsConstructor
@AllArgsConstructor
public class Doctors {

	@Id
	private Integer id;
	private String name;
	private Double income;
}
