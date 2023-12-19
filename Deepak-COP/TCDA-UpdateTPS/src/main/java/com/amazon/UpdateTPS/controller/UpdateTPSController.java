package com.amazon.UpdateTPS.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amazon.UpdateTPS.model.UpdateDataInTable;


@Controller
public class UpdateTPSController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@Validated UpdateDataInTable user, Model model) {
		
		model.addAttribute("StableTPS", user.getStableTPS());
		model.addAttribute("CurrentTPS", user.getCurrentTPS());
		model.addAttribute("Region", user.getRegion());
		model.addAttribute("Fleet", user.getFleet());
		model.addAttribute("NoOFHosts", user.getNoOfHosts());
		model.addAttribute("Result", user.Results());
		
		
		return "home";
	}


}
