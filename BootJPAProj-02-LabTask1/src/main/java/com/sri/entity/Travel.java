package com.sri.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="TRAVELJPA")
@Data
public class Travel {

	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(name="destination",length=25)
	private String destination;
	@Column(name="transportationmode",length=25)
	private String transportationMode;
	@Column(name="price")
	private Double price;
}
