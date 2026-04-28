package com.sri.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.entity.BankAccount;

public interface AccountRepo extends JpaRepository<BankAccount, Long> {

}
