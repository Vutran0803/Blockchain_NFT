package com.othree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/index")
	public String index() {
		return "Othree/index";
	}

	@GetMapping("/contact")
	public String contact() {
		return "Othree/contact";
	}

	@GetMapping("/about")
	public String about() {
		return "Othree/about";
	}

	@GetMapping("/faq")
	public String faq() {
		return "Othree/faq";
	}

	@GetMapping("/feature")
	public String feature() {
		return "Othree/feature";
	}

	@GetMapping("/myNFTs")
	public String myNFTs() {
		return "Othree/myNFTs";
	}
	@GetMapping("//marketplace")
	public String marketplace() {
		return "Othree/marketplace";
	}

	@GetMapping("/service")
	public String service() {
		return "Othree/service";
	}
	@GetMapping("/transfer")
	public String transfer() {
		return "Othree/transfer";
	}
	@GetMapping("/transferSOL")
	public String transferSOL() {
		return "Othree/transferSOL";
	}
	@GetMapping("/createNFT")
	public String token() {
		return "Othree/createNFT";
	}

	@GetMapping("/register")
	public String register() {
		return "Othree/register";
	}

	@GetMapping("/login")
	public String login() {
		return "Othree/login";
	}

}
