package com.sri.service;

import java.util.Optional;

import com.sri.entity.Bank;

public interface IBankService {
String create(Bank b);
Iterable<Bank> display();
String update(Bank b);
String delete(Integer id);
Optional<Bank> find(Integer id);
}
