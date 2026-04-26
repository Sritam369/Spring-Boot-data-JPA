package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="idcard_one")
@NoArgsConstructor
@RequiredArgsConstructor
public class IdCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardNumber;
	@NonNull
	private String cardType;
	@NonNull
	private String acessLevel;
	@NonNull
	private String issuedBy;
	
}
