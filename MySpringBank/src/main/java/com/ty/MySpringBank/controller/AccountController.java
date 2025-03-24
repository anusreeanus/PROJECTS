package com.ty.MySpringBank.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ty.MySpringBank.model.Account;
import com.ty.MySpringBank.model.Transaction;
import com.ty.MySpringBank.service.AccountService;

@Controller
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/create")
	public String showCreateAccountForm(Model model) {
		model.addAttribute("account", new Account());
		return "create-account";
	}

	@PostMapping("/create")
	public String createAccount(@ModelAttribute Account account) {
		accountService.createAccount(account);
		return "redirect:/accounts/create";
	}

	@GetMapping("/deposit")
	public String showDepositForm() {
		return "deposit";
	}

	@PostMapping("/deposit")
	@ResponseBody
//	public String deposit(@RequestParam String accountNumber, @RequestParam double amount, RedirectAttributes redirectAttributes) throws AccountNotFoundException {
//	    accountService.deposit(accountNumber, amount);
//	    redirectAttributes.addFlashAttribute("successMessage", "Deposit successful for account " + accountNumber);
//	    return "redirect:/accounts/deposit";
//	}
	public ResponseEntity<String> deposit(@RequestParam String accountNumber, 
            @RequestParam double amount) throws AccountNotFoundException {
accountService.deposit(accountNumber, amount);
return ResponseEntity.ok("Deposit successful for account " + accountNumber);
}
	@GetMapping("/withdraw")
	public String showWithdrawForm() {
		return "withdraw";
	}

	@PostMapping("/withdraw")
	public String withdraw(@RequestParam String accountNumber, @RequestParam double amount) throws AccountNotFoundException {
		accountService.withdraw(accountNumber, amount);
		return "redirect:/accounts/withdraw";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

	@GetMapping("/about1")
	public String about2() {
		return "about1";
	}

	@GetMapping("/service")
	public String service() {
		return "service1";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/trans")
	public String about1() {
		return "trans1";
	}

	@GetMapping("/gettransaction/{accountNumber}")
	public String getTransactionHistory(@PathVariable String accountNumber, Model model) throws AccountNotFoundException {
	    List<Transaction> transactions = accountService.getTransactionHistory(accountNumber);
	    model.addAttribute("trans", transactions);
	    return "trans";
	}


}
