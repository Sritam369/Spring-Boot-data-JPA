package com.sri.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee_Date_Time {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer eno;
	@Nonnull
	private String ename;
	@Nonnull
	private String desg;
	@Nonnull
	private LocalDateTime dob;
	@Nonnull
	private LocalTime toj;
	@Nonnull
	private LocalDate doj;
}
