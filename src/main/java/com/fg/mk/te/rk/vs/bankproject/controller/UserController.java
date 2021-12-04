package com.fg.mk.te.rk.vs.bankproject.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fg.mk.te.rk.vs.bankproject.beans.UserClass_A;
import com.fg.mk.te.rk.vs.bankproject.service.UserService;

@Controller
public class UserController {
	@Autowired
	public UserService userService;
	HttpSession session;
	String fullname = null;

	@RequestMapping(value="/Welcome", method = RequestMethod.GET)
	public String Welcome(Model m) {
		
		return "Welcome";
	}

	@RequestMapping(value="/Login", method = RequestMethod.GET)
	public String Login(Model m) {
		m.addAttribute("command", new UserClass_A());
		return "Login";
	}

	@RequestMapping(value = "/loginVerification", method = RequestMethod.POST)
	public String loginVerification(@ModelAttribute("user") UserClass_A user, HttpServletRequest request) {
		System.out.println("IMPLEME ******: " + user.getUsername());
		UserClass_A userValidate = userService.validateUser(user);
		System.out.println("userValidate: " + userValidate);
		session = request.getSession();
		if (userValidate != null) { // SUCCESS
			String lastname = userValidate.getLastname() != null ? userValidate.getLastname() : "";
			fullname = userValidate.getFname() + ' ' + lastname;
			session.setAttribute("username", userValidate.getUsername());
			session.setAttribute("fullname", fullname);
			session.removeAttribute("error");
			return "redirect:/Welcome";			 
		} else { // FAILURE
			session.setAttribute("error", "Username or password doesn't match. Please Try again!");
			return "redirect:/Login";
		}
	}


	@RequestMapping(value="/Register", method = RequestMethod.GET)
	public String Register(Model m) {
		m.addAttribute("command", new UserClass_A());
		return "Register";
	}

	@RequestMapping(value = "/RegisterVerfication", method = RequestMethod.POST)
	public String RegisterVerfication(@ModelAttribute("newuser") UserClass_A newuser, HttpServletRequest request) {
		System.out.println("IMPLEME ******: REGISTER" + newuser.getUsername());
		int register = userService.RegisterLogin(newuser);
		System.out.println("userValidate: " + register);
		if(register != 0) { // SUCCESS
			String lastname = newuser.getLastname() != null ? newuser.getLastname() : "";
			fullname = newuser.getFname() + ' ' + lastname;
			session = request.getSession();
			session.setAttribute("username", newuser.getUsername());
			session.setAttribute("fullname", fullname);
			session.removeAttribute("error");
			return "redirect:/Welcome";			
		} else { // FAILURE
			return "redirect:/Register";
		}
	}

	@ModelAttribute("newuser")
	public UserClass_A getDefaultuser() {
		return new UserClass_A();
	}

	@ModelAttribute("genderItems")
	public List<String> getGenderItems() {
		return Arrays.asList(new String[] {"Male", "Female", "Other"});
	}

}
