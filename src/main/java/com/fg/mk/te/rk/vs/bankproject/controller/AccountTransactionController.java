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
import com.fg.mk.te.rk.vs.bankproject.beans.UserAccountClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;
import com.fg.mk.te.rk.vs.bankproject.beans.UtilityClass_A;
import com.fg.mk.te.rk.vs.bankproject.service.AccountTransactionService;

@Controller
public class AccountTransactionController {
	@Autowired
	public AccountTransactionService accountTransactionService;
	HttpSession session;

	@RequestMapping(value="/Accounts", method = RequestMethod.GET)
	public String Accounts(Model m, HttpServletRequest request) {
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
		if(register != 0) { // SUCCESS
			int updateAccounts = accountTransactionService.UpdateAccount(newTransaction);
			if (updateAccounts != 0) {
				return "redirect:/Accounts";			
			}
			return "";
		} else {
			return "";
		}
	}

	@RequestMapping(value="/ShowAccount/DepositToSameAccount/{id}", method = RequestMethod.GET)
	public String DepositToSameAccount(@PathVariable int id, Model m, HttpServletRequest request) {
		m.addAttribute("command", new TransactionClass_A());
		return "DepositToSameAccount";
	}

	@RequestMapping(value = "/ShowAccount/DepositToSameAccount/PostDepositTransaction", method = RequestMethod.POST)
	public String PostDepositTransaction(@ModelAttribute("newTransaction") TransactionClass_A newTransaction, HttpServletRequest request) {
		int register = accountTransactionService.depositSameAccount(newTransaction, null );
		if(register != 0) { // SUCCESS
			int updateAccounts = accountTransactionService.updateDepositSameAccount(newTransaction);
			if (updateAccounts != 0) {
				return "redirect:/Accounts";			
			}
			return "";
		} else {
			return "";
		}
	}

	// LIST ALL UITLITIES
	@RequestMapping(value="/ListAllUtilities", method = RequestMethod.GET)
	public String ListAllUtilities(Model m, HttpServletRequest request) {
		System.out.println("***********************");
		List<UtilityClass_A> accounts = accountTransactionService.getListAllUtilities();
		m.addAttribute("listUtilities", accounts);
		return "ListAllUtilities";
	}

	// ADD UTILITY
	@RequestMapping(value="/AddUtility", method = RequestMethod.GET)
	public String AddUtility(Model m, HttpServletRequest request) {
		m.addAttribute("command", new UtilityClass_A());
		return "AddUtility";
	}

	@RequestMapping(value = "/RegisterUtility", method = RequestMethod.POST)
	public String RegisterVerfication(@ModelAttribute("newutility") UtilityClass_A newutility, HttpServletRequest request) {
		//		System.out.println("IMPLEME ******: REGISTER" + newuser.getUsername());
		int register = accountTransactionService.AddUtilityDB(newutility);
		System.out.println("userValidate: " + register);
		if(register != 0) { // SUCCESS
			//			fullname = newuser.getFname() + ' ' + newuser.getLastname();
			//			session = request.getSession();
			//			session.setAttribute("username", newuser.getUsername());
			//			session.setAttribute("fullname", fullname);
			return "redirect:/ListAllUtilities";			
		} else { // FAILURE
			return "redirect:/AddUtility";
		}
	}

	// Get UTILITY using id
	@RequestMapping(value="/EditUtility/{id}", method = RequestMethod.GET)
	public String RegisterUtility(@PathVariable int id, Model m, HttpServletRequest request) {
		UtilityClass_A utility = accountTransactionService.getUtilityByIdDB(id);
		m.addAttribute("utility", utility);
		return "EditUtility";
	}

	// Update UTILITY
	@RequestMapping(value = "/EditUtility/EditUitilitySave", method = RequestMethod.POST)
	public String EditUitilitySave(@ModelAttribute("utility") UtilityClass_A utility, HttpServletRequest request) {
		System.out.println("userupdat-----------------------------------: " );
		//		System.out.println("IMPLEME ******: REGISTER" + newuser.getUsername());
		int update = accountTransactionService.updateUtilityDB(utility);
		if(update != 0) { // SUCCESS
			//			fullname = newuser.getFname() + ' ' + newuser.getLastname();
			//			session = request.getSession();
			//			session.setAttribute("username", newuser.getUsername());
			//			session.setAttribute("fullname", fullname);
			return "redirect:/ListAllUtilities";			
		} else { // FAILURE
			return "EditUtility";
		}
	}

	// Delete UTILITY
	@RequestMapping(value = "/DeleteUtility/{id}", method = RequestMethod.GET)
	public String DeleteUtility(@PathVariable int id, HttpServletRequest request) {
		//		System.out.println("IMPLEME ******: REGISTER" + newuser.getUsername());
		int delete = accountTransactionService.deleteUtilityDB(id);
		System.out.println("userupdate: " + delete);
		if(delete != 0) { // SUCCESS
			//			fullname = newuser.getFname() + ' ' + newuser.getLastname();
			//			session = request.getSession();
			//			session.setAttribute("username", newuser.getUsername());
			//			session.setAttribute("fullname", fullname);
			return "redirect:/ListAllUtilities";			
		} else { // FAILURE
			return "redirect:/ListAllUtilities";
		}
	}

	// Pay UTILITY
	@RequestMapping(value="/PayUtility", method = RequestMethod.GET)
	public String PayUtility(Model m, HttpServletRequest request) {
		//		TransactionClass_A transaction = accountTransactionService.getUtilityByIdDB(id);
		m.addAttribute("command", new TransactionClass_A());
		return "PayUtility";
	}


	// Update UTILITY
	@RequestMapping(value = "/PostPayBill", method = RequestMethod.POST)
	public String PostPayBill(@ModelAttribute("payBill") TransactionClass_A payBill, HttpServletRequest request) {
		int billPayed = accountTransactionService.depositSameAccount(payBill, "payBill" );
		if(billPayed != 0) { // SUCCESS
			int updateAccounts = accountTransactionService.updatePayBillUtilityDB(payBill);
			int updateAccountUtility = accountTransactionService.updatePayBillAccountUtilityDB(payBill);
			if (updateAccounts != 0 && updateAccountUtility != 0) {
				return "redirect:/ListAllUtilities";			
			}
			return "";
		} else {
			return "";
		}
	}

	// View Profile
	@RequestMapping(value="/ViewProfile", method = RequestMethod.GET)
	public String ViewProfile(Model m, HttpServletRequest request) {
		session = request.getSession();
		String uname = (String) session.getAttribute("username");
		System.out.println("getUserByIdDB: " + uname);
		UserClass_A user = accountTransactionService.getUserByIdDB(uname);
		m.addAttribute("user", user);
		return "ViewProfile";
	}

	@RequestMapping(value = "/UpdateViewProfile", method = RequestMethod.POST)
	public String UpdateViewProfile(@ModelAttribute("user") UserClass_A user, HttpServletRequest request) {
		int register = accountTransactionService.updateUserDB(user);
		if(register != 0) { // SUCCESS
			String lastname = user.getLastname() != null ? user.getLastname() : "";
			String fullname = user.getFname() + ' ' + lastname;
			session = request.getSession();
			session.setAttribute("fullname", fullname);
			return "redirect:/Welcome";			
		} else {
			return "";
		}
	}

	// LIST ALL Users
	@RequestMapping(value="/ListAllUsers", method = RequestMethod.GET)
	public String ListAllUsers(Model m, HttpServletRequest request) {
		System.out.println("***********************");
		//		session = request.getSession();
		//		String uname = (String) session.getAttribute("username");
		List<UserAccountClass_A> users = accountTransactionService.getListAllUsers();
		m.addAttribute("listUsers", users);
		return "ListAllUsers";
	}

	// Get User By Id
	@RequestMapping(value="/EditUserAccount/{id}/{accountId}", method = RequestMethod.GET)
	public String EditUserAccount(@PathVariable int id, @PathVariable int accountId, Model m, HttpServletRequest request) {
		UserAccountClass_A userAccount = accountTransactionService.getUserByIdAdminDB(accountId);
		m.addAttribute("userAccount", userAccount);
		return "EditUserAccount";
	}

	// Update UTILITY
	@RequestMapping(value = "/EditUserAccount/{id}/EditUserAccountSave", method = RequestMethod.POST)
	public String EditUserAccountSave(@ModelAttribute("user") UserClass_A user, HttpServletRequest request) {
		//			System.out.println("IMPLEME ******: REGISTER" + newuser.getUsername());
		int update = accountTransactionService.updateUserDB(user);
		if(update != 0) { // SUCCESS
			return "redirect:/ListAllUsers";			
		} else { // FAILURE
			return "";
		}
	}

	// Activate Account
	@RequestMapping(value = "/Activate/{id}/{accountId}", method = RequestMethod.GET)
	public String ActivateAccount(@PathVariable int id, @PathVariable int accountId, HttpServletRequest request) {
		int activate = accountTransactionService.activateDeactivateAccountDB(accountId, 1);
		System.out.println("userupdate: " + activate);
		if(activate != 0) { // SUCCESS
			return "redirect:/ListAllUsers";			
		} else { // FAILURE
			return "redirect:/ListAllUsers";
		}
	}


	// Deactivate Account
	@RequestMapping(value = "/DeactivateAccount/{id}/{accountId}", method = RequestMethod.GET)
	public String DeactivateAccount(@PathVariable int id, @PathVariable int accountId, HttpServletRequest request) {
		int activate = accountTransactionService.activateDeactivateAccountDB(accountId, 0);
		System.out.println("userupdate: " + activate);
		if(activate != 0) { // SUCCESS
			return "redirect:/ListAllUsers";			
		} else { // FAILURE
			return "redirect:/ListAllUsers";
		}
	}

	// Add Account for existing User Account
	@RequestMapping(value = "/AddAccountExistinguser", method = RequestMethod.GET)
	public String AddAccountExistinguser(Model m, HttpServletRequest request) {
		m.addAttribute("command", new UserAccountClass_A());
		return "AddAccountExistinguser";
	}

	// ADD New Accounts to the existsing user
	@RequestMapping(value = "/PostAddExistingUserAccount", method = RequestMethod.POST)
	public String PostAddExistingUserAccount(@ModelAttribute("userAccount") UserAccountClass_A userAccount, HttpServletRequest request) {
		System.out.println("____________________QWE: " + userAccount.getIdusers());
		int registerAccount = accountTransactionService.RegisterNewAccountTable(userAccount, userAccount.getIdusers());
		if(registerAccount != 0) { // SUCCESS
			return "redirect:/ListAllUsers";			
		} else { // FAILURE
			return "";
		}
	}

	// ADD New Accounts to the existsing user
	@RequestMapping(value = "/PostAddNewuserAccount", method = RequestMethod.POST)
	public String PostAddNewuserAccount(@ModelAttribute("userAccount") UserAccountClass_A userAccount, HttpServletRequest request) {
		int resgiterUser = accountTransactionService.RegisterNewUserTable(userAccount);
		int fetchlastUserId = accountTransactionService.fetchlastuserId();
		System.out.println("NUMBERTERTERRERERE --------------------: " + fetchlastUserId);
		int registerAccount = accountTransactionService.RegisterNewAccountTable(userAccount, fetchlastUserId);
		if(resgiterUser != 0 && registerAccount != 0) { // SUCCESS
			return "redirect:/ListAllUsers";			
		} else { // FAILURE
			return "";
		}
	}


	// Add Account for New User Account
	@RequestMapping(value = "/AddAccountNewUser", method = RequestMethod.GET)
	public String AddAccountNewUser(Model m, HttpServletRequest request) {
		m.addAttribute("command", new UserAccountClass_A());
		return "AddAccountNewUser";
	}

	// LOGOUT
	@RequestMapping(value="/Logout", method = RequestMethod.GET)
	public String Logout(Model m, HttpServletRequest request) {
		session.removeAttribute("fullname");
		session.removeAttribute("username");
		return "redirect:/Login";
	}

	/******************************************************** MODEL ATTRIBUTE ************************************************************/
	@ModelAttribute("payBill")
	public TransactionClass_A getPayBill() {
		System.out.println("-------3: ");
		return new TransactionClass_A();
	}

	@ModelAttribute("addExistingUserAccountAdmin")
	public UserAccountClass_A getaddExistingUserAccountAdmin() {
		System.out.println("-------3: ");
		return new UserAccountClass_A();
	}

	@ModelAttribute("listUtilitiesToPay")
	public List<UtilityClass_A> getYourListUtilitiesToPay(HttpServletRequest request) {
		return  accountTransactionService.getListAllUtilitiesExceptZero();
	}

	@ModelAttribute("listAllExistingUser")
	public List<UserAccountClass_A> getListAllExistingUser(HttpServletRequest request) {
		return accountTransactionService.getListAllUsers();
	}

	// Show all Users Account
	@ModelAttribute("listAllUserAccountAdmin")
	public List<UserClass_A> listAllUserAccountAdmin(HttpServletRequest request) {
		return accountTransactionService.getListAllUsersForAdmin();
	}

	// Show all Users Account
	@ModelAttribute("listAllYourAccounts")
	public List<AccountClass_A> listAllYourAccounts(HttpServletRequest request) {
		session = request.getSession();
		System.out.println("-------2: " + session.getAttribute("accountId"));
		if (session.getAttribute("username") != null)
		{
			String id = (String) session.getAttribute("username");
			return accountTransactionService.getListAllYourAccounts(id);
		} else {
			return null;
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

	@ModelAttribute("genderItems")
	public List<String> getGenderItems() {
		return Arrays.asList(new String[] {"Male", "Female", "Other"});
	}
}
