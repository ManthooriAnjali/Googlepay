package com.gpay.Googlepay.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gpay.Googlepay.Dto.FundTransfer;

@FeignClient(name="bank-account",url="http://localhost:8081/Bank")
public interface BankAccountClient {
	
	@GetMapping("/fundTransfer/getAccountIDfromPhone/{phoneNumber}")
	public Long getAccountIdFromPhoneNumber(@PathVariable String phoneNumber);
	
	@PostMapping("/fundTransfer")
	public void transferFund(@RequestBody FundTransfer fundTransfer);


}
