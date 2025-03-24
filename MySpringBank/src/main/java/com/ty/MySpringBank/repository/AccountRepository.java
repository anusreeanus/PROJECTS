package com.ty.MySpringBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.MySpringBank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	Account findByAccountNumber(String accountNumber);
}
