package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Login;
import com.repository.LoginRepository;
import com.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	
	@Autowired LoginRepository loginRepository;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String open(Model mm, Login ll) {
		mm.addAttribute("login", ll);
		return "index";
	}
	
	@RequestMapping(value = "/openSignUp",method = RequestMethod.GET)
	public String openSignUpPage(Model mm, Login ll) {
		mm.addAttribute("login", ll);
		return "signUp";
	}
	
	@RequestMapping(value = "/signIn",method = RequestMethod.POST)
	public String signIn(Model mm, Login ll,HttpSession hs) {
		String result = loginService.signIn(ll);
		
		if(result.equals("Customer login successfully")) {
			hs.setAttribute("emailid", ll.getEmailid());		// stored session object of that person 
			return "customerHome";
		}else if(result.equals("Admin login successfully")) {
			return "adminHome";
		}else {
			return "index";
		}
		
		//System.out.println(result);
		//mm.addAttribute("login", ll);
		//return "index";
	}
	
	
	@RequestMapping(value = "/signUp",method = RequestMethod.POST)
	public String signUp(Model mm, Login ll) {
		String result = loginService.signUp(ll);
		mm.addAttribute("login", ll);
		System.out.println(result);

		return "index";

	}
	
//	@RequestMapping(value = "/viewLoginPage",method = RequestMethod.GET)
//	public String viewLogin(Model mm, Login ll) {
//		List<Login> listofLogins = loginService.findAllLogin();
//		mm.addAttribute("login", listofLogins);
//		return "viewLogin";
	
	@RequestMapping(value = "/viewLoginPage",method = RequestMethod.GET)
	public String viewLogin(Model mm, @Param("keyword") String keyword, Login ll) {
	
			 if(keyword == null)
				 {
				 
				 List<Login> listofLogins = loginService.findAllLogin();
				 mm.addAttribute("login", listofLogins);
				 } else {List<Login> listofLogins = loginRepository.findByEmailidContainingIgnoreCase(keyword);
				          mm.addAttribute("keyword", keyword);
				          mm.addAttribute("login", listofLogins);
				 }
		
		return "viewLogin";
	}

}
