package com.gpay.Googlepay.controller;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpay.Googlepay.entity.Googlepay;
import com.gpay.Googlepay.entity.GooglepayTransfer;
import com.gpay.Googlepay.service.GooglepayService;

@RestController
@RequestMapping("/Customers")
public class GooglepayController {
	@Autowired
	GooglepayService googlepayService;


	@PostMapping("/registerGooglepay")
	public  Googlepay addGooglepay(@RequestBody Googlepay googlepay) {

		return googlepayService.registerGooglepay(googlepay);
	}

	@GetMapping("/{googlepayId}")
	public Googlepay getGooglepayById(@PathVariable Long gpayId) throws AccountNotFoundException {
		return  googlepayService.getGooglepayById(gpayId);
	}

	@GetMapping("/generateStatement/{phoneNumber}")
	public List<GooglepayTransfer> generateStatement(@PathVariable String phoneNumber)  {

		return googlepayService.generateStatement(phoneNumber);
	}
}
