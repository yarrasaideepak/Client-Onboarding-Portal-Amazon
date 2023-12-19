package com.Amazon.COP.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Amazon.COP.model.CompareTPS;

@Controller
public class FleetCapacityController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@Validated CompareTPS user, Model model) {
		
		model.addAttribute("Capacity", user.getCapacity() );
		model.addAttribute("FleetName", user.getFleet() );
		model.addAttribute("RegionName", user.getRegion() );
		
		return "home";
	}


}
