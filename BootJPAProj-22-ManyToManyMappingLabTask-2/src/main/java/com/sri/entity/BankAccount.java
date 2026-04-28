package com.sri.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@Getter
@Setter
@Table(name="bank_account_one_to_many_mapping")
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "acc_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Long accId;
	@NonNull
	private String accType;
	@NonNull
	private Double balance;
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="accounts")
	private List<Customer> custs = new ArrayList<>() ;
	@Override
	public String toString() {
		return "BankAccount [accId=" + accId + ", accType=" + accType + ", balance=" + balance + "]";
	}
	
	
}
