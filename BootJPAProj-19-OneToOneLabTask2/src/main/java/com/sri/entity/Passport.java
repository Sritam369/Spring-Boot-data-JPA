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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Passport_oneToOne")
@RequiredArgsConstructor
@NoArgsConstructor
public class Passport {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "s5",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	private String passportNumber;
	@NonNull
	private String country;
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="cust_id",referencedColumnName = "id")
	private Customer cust;
	@Override
	public String toString() {
		return "Passport [id=" + id + ", passportNumber=" + passportNumber + ", country=" + country + "]";
	}
	
	

}

