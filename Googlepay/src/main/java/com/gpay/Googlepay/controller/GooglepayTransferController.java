package com.gpay.Googlepay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gpay.Googlepay.entity.GooglepayTransfer;
import com.gpay.Googlepay.service.GooglepayTransferService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/fundTransfer")
public class GooglepayTransferController {
	

	@Autowired
	GooglepayTransferService googlepayTransferService;	
	
	@PostMapping
	@HystrixCommand(fallbackMethod="transferFundFallBackMethod")
	public GooglepayTransfer transferFund(@RequestBody  GooglepayTransfer  googlepayTransfer)  {
		return googlepayTransferService.transferFund( googlepayTransfer);
		
	}
	
	
	public GooglepayTransfer transferFundFallBackMethod(@RequestBody  GooglepayTransfer  googlepayTransfer) {
		
		googlepayTransfer.setComments("Not able to transfer");
		googlepayTransfer.setTransferAmount(0);
		return googlepayTransfer;
	}
	

}
