package com.nouvolution.testSecurity.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users*")
@Controller
public class SecurityController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/login")
	public String loginPage(String error, String logout, Model model) {
		logger.info("access to login page");
		logger.info("[Error] :: " + error);
		logger.info("[Logout] :: " + logout);
		
		if(error != null) {
			model.addAttribute("error", "failed login");
		}
		if(logout != null) {
			model.addAttribute("logout", "Logout");
		}
		
		return "/login";
	}
	
	@PostMapping("/login-processing")
	public void loginProcessing(String error) {
		logger.info("login-processing");
		logger.info("[Error] :: " + error);
	}
	
	@GetMapping("/member")
	public String doMember() {
		// TODO Auto-generated method stub
		logger.info("logined member");
		
		return "/member";
	}
	
	@GetMapping("/admin")
	public String doAdmin() {
		logger.info("admin only");
		
		return "/admin";
	}	
	
}
