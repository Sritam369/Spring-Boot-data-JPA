package com.sri.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class MarriageSeeker implements Serializable {

	@Id
	@SequenceGenerator(name="ge1",initialValue = 100,allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Nonnull
	private String name;
	@Nonnull
	private String addrs;
	@Nonnull
	@Lob
	private byte[] photo;
	@Nonnull
	private LocalDateTime dob;
	@Nonnull
	@Lob
	private char[] biodata;
	@Nonnull
	private boolean indian;
}
