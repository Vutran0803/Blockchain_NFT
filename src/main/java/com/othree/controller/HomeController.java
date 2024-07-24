package com.othree.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.othree.dao.ImageNFTDao;
import com.othree.entity.ImageNFT;

@Controller
public class HomeController {
	
	@Autowired
    private ImageNFTDao dao;

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
	public String roadmap() {
		return "Othree/myNFTs";
	}

	@GetMapping("/service")
	public String service() {
		return "Othree/service";
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
	@GetMapping("/marketplace")
	public String getNFTMarketplace(Model model) {
	    List<ImageNFT> nfts = dao.findAll();
	    model.addAttribute("nfts", nfts);
	    return "Othree/marketplace";
	}

	


   


}
