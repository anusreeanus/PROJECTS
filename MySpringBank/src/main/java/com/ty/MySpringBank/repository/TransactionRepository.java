package com.ty.MySpringBank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.MySpringBank.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByAccountId(Long accountId);
}
