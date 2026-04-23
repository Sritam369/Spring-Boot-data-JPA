package com.sri.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="Customer_oneToOne")
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s4",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String nationality;
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="cust_id",referencedColumnName = "id")
	private Passport pass;
	
	
	
}
