package com.sri.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sri.entity.Product;

import jakarta.transaction.Transactional;

public interface ProductRepo extends JpaRepository<Product, Long> {

	@Query("FROM Product where catagory=?1") // ordinal positional param
	List<Product> SearchByCatagory(String cat);
	@Query("from Product where price<:p") // named positional param
	List<Product> searchByLessThanPrice(@Param("p")Double p);
	@Query("from Product where stock>0")
	List<Product>serchByStockGreaterThan0();
	@Query("FROM Product p WHERE LOWER(p.name) like %:word% ")
	List<Product> searchByKeyword(@Param("word")String word);
	@Query("update Product set name=?1 where name=?2 ")
	@Modifying
	@Transactional
	int updateName(String newName,String oldName);
}
