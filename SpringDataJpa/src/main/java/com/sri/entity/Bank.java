package com.sri.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bankjpa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

	@Id
	private Integer accid;
	private String name;
	private Double balance;
	private String accType;
}
