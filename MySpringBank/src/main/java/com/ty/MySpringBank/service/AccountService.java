package com.ty.MySpringBank.service;

import java.util.Date;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.MySpringBank.model.Account;
import com.ty.MySpringBank.model.Transaction;
import com.ty.MySpringBank.repository.AccountRepository;
import com.ty.MySpringBank.repository.TransactionRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private TransactionRepository transactionRepository;

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account getAccountByNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber);
	}

	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		Account account = accountRepository.findByAccountNumber(accountNumber);

	    if (account == null) {
	        throw new AccountNotFoundException("Account number " + accountNumber + " not found.");
	    }
		account.setBalance(account.getBalance() + amount);
		accountRepository.save(account);
		
		Transaction transaction = new Transaction();
		transaction.setAccount(account);
		transaction.setAmount(amount);
		transaction.setType("Deposit");
		 transaction.setTransactionDate(new Date()); 
		transactionRepository.save(transaction);
		

	}

	public void withdraw(String accountNumber, double amount) throws AccountNotFoundException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		  if (account == null) {
		        throw new AccountNotFoundException("Account number " + accountNumber + " not found.");
		    }
		    if (account.getBalance() < amount) {
		        throw new RuntimeException("Insufficient balance in account " + accountNumber);
		    }
			account.setBalance(account.getBalance() - amount);
			accountRepository.save(account);
			Transaction transaction = new Transaction();
			transaction.setAccount(account);
			transaction.setAmount(amount);
			transaction.setType("Withdraw");
			transaction.setTransactionDate(new Date());
			transactionRepository.save(transaction);
		} 
	

	public List<Transaction> getTransactionHistory(String accountNumber) throws AccountNotFoundException {
		Account account = accountRepository.findByAccountNumber(accountNumber);
		   if (account == null) {
		        throw new AccountNotFoundException("Account number " + accountNumber + " does not exist.");
		    }
		    return transactionRepository.findByAccountId(account.getId());
	}

}
