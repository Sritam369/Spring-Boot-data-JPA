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
@Table(name="cust_one_to_many_mapping")
@NoArgsConstructor
@RequiredArgsConstructor
public class Customer {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "cust_seq",initialValue = 100,allocationSize = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Long custId;
	@NonNull
	private String custName;
	@NonNull
	private String city;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="customer_account_mappng",joinColumns =@JoinColumn(name="cust_id",referencedColumnName ="custId"),inverseJoinColumns = @JoinColumn(name="account_id",referencedColumnName = "accId") )
	private List<BankAccount> accounts = new ArrayList<>() ;
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", city=" + city + "]";
	}
	
}
