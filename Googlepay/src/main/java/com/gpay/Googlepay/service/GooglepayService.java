package com.gpay.Googlepay.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.gpay.Googlepay.entity.Googlepay;
import com.gpay.Googlepay.entity.GooglepayTransfer;

public interface GooglepayService {

	List<GooglepayTransfer> generateStatement(String phoneNumber);

	Googlepay getGooglepayById(Long gpayId) throws AccountNotFoundException;

	 Googlepay registerGooglepay(Googlepay googlepay) ;


}
