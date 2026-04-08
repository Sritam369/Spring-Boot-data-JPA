package com.sri.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="product_jpa")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	private Long id;
	private String name;
	private String catagory;
	private Double price;
	private Integer stock;
}
