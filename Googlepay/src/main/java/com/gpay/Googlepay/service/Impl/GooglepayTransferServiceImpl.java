package com.gpay.Googlepay.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gpay.Googlepay.Dto.FundTransfer;
import com.gpay.Googlepay.Repository.GooglepayTransferRepository;
import com.gpay.Googlepay.entity.GooglepayTransfer;
import com.gpay.Googlepay.feignClient.BankAccountClient;
import com.gpay.Googlepay.service.GooglepayTransferService;
@Service
public class GooglepayTransferServiceImpl implements GooglepayTransferService{

	@Autowired
	GooglepayTransferRepository googlepayTransferRepository;

	@Autowired
	BankAccountClient bankAccountClient;

	@Override
	public GooglepayTransfer transferFund(GooglepayTransfer googlepayTransfer) {
		FundTransfer fundTransfer = new FundTransfer();

		Long fromAccountID = bankAccountClient.getAccountIdFromPhoneNumber(googlepayTransfer.getFromPhoneNumber());
		System.out.println("fromAccountID - "+fromAccountID);
		Long toAccountID = bankAccountClient.getAccountIdFromPhoneNumber(googlepayTransfer.getToPhoneNumber());
		System.out.println("toAccountID - " + toAccountID);
		fundTransfer.setAmountToTransfer(googlepayTransfer.getTransferAmount());
		fundTransfer.setFromAccountID(fromAccountID);
		fundTransfer.setToAccountID(toAccountID);

		bankAccountClient.transferFund(fundTransfer);

		System.out.println("toAccountID after fund transfer - " + toAccountID);
		return googlepayTransferRepository.save(googlepayTransfer);


	}

}
