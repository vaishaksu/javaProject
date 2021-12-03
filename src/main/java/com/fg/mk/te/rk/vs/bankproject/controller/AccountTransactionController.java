package com.fg.mk.te.rk.vs.bankproject.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fg.mk.te.rk.vs.bankproject.beans.AccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.TransactionClass_A;
import com.fg.mk.te.rk.vs.bankproject.service.AccountTransactionService;

@Controller
public class AccountTransactionController {
	@Autowired
	public AccountTransactionService accountTransactionService;
	HttpSession session;

	@RequestMapping(value="/Accounts", method = RequestMethod.GET)
	public String Accounts(Model m, HttpServletRequest request) {
		System.out.println("***********************");
		session = request.getSession();
		String uname = (String) session.getAttribute("username");
		List<AccountClass_A> accounts = accountTransactionService.getListAccounts(uname);
		m.addAttribute("listAccount", accounts);
		return "Accounts";
	}

	@RequestMapping(value="/ShowAccount/{id}", method = RequestMethod.GET)
	public String ShowAccount(@PathVariable int id, Model m, HttpServletRequest request) {
		session = request.getSession();
		session.setAttribute("accountId", id);
		AccountClass_A account = accountTransactionService.getAccountById(id);
		//		List<AccountClass_A> yourOtherAccounts = accountTransactionService.getListOtherAccountOfYours(id);
		m.addAttribute("account", account);
		return "ShowAccount";
	}

	@RequestMapping(value="/ShowAccount/TransferDifferentAccount/{id}", method = RequestMethod.GET)
	public String TransferDifferentAccount(@PathVariable int id, Model m, HttpServletRequest request) {
		//		session = request.getSession();
		m.addAttribute("command", new TransactionClass_A());
		//		String uname = (String) session.getAttribute("username");
		//		List<AccountClass_A> accounts = accountTransactionService.getListOtherAccountOfYours(id);
		//		m.addAttribute("listAccounts", accounts);
		return "TransferDifferentAccount";
	}

	@RequestMapping(value = "/ShowAccount/TransferDifferentAccount/PostTransaction", method = RequestMethod.POST)
	public String PostTransaction(@ModelAttribute("newTransaction") TransactionClass_A newTransaction, HttpServletRequest request) {
		int register = accountTransactionService.RegisterTransaction(newTransaction);

		//		System.out.println("IMPLEME ******: REGISTER" + newuser.getUsername());
		//		System.out.println("userValidate: " + register);
		if(register != 0) { // SUCCESS
			//			fullname = newuser.getFname() + ' ' + newuser.getLastname();
			//			session = request.getSession();
			//			session.setAttribute("username", newuser.getUsername());
			//			session.setAttribute("fullname", fullname);
			return "redirect:/Accounts";			
		} else {
			return "";
		}
	}


	@ModelAttribute("listYourOtherAccounts")
	public List<AccountClass_A> getlistYourOtherAccounts(HttpServletRequest request) {
		session = request.getSession();
		System.out.println("-------1: " + session.getAttribute("accountId"));

		if (session.getAttribute("accountId") != null)
		{
			int id = (Integer) session.getAttribute("accountId");
			return  accountTransactionService.getListOtherAccountOfYours(id);
		} else {
			return Arrays.asList(new AccountClass_A());
		}
	}

	@ModelAttribute("newTransaction")
	public TransactionClass_A getDefaultTransaction() {
		System.out.println("-------3: ");
		return new TransactionClass_A();
	}

	@ModelAttribute("yourAccounts")
	public AccountClass_A getYourAccounts(HttpServletRequest request) {
		session = request.getSession();
		System.out.println("-------2: " + session.getAttribute("accountId"));
		if (session.getAttribute("accountId") != null)
		{
			int id = (Integer) session.getAttribute("accountId");
			return  accountTransactionService.getAccountById(id);
		} else {
			return null;
		}
	}
}
