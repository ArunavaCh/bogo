package com.bogo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bogo.services.BogoService;

@RestController
public class BogoController {

	@Autowired
	BogoService bogoService;
	
	@GetMapping("/getProductWithDiscount")
	public Map<String, List<Integer>> getProductWithDiscount(@RequestBody List<Integer> prodPrices) {

	     return bogoService.maximizeDiscount(prodPrices);
	}
}
