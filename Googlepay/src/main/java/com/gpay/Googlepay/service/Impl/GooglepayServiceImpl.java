package com.gpay.Googlepay.service.Impl;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gpay.Googlepay.Dto.GooglepayDetailsDto;
import com.gpay.Googlepay.Repository.GooglepayRepository;
import com.gpay.Googlepay.entity.Googlepay;
import com.gpay.Googlepay.entity.GooglepayTransfer;
import com.gpay.Googlepay.service.GooglepayService;

@Service
public class GooglepayServiceImpl implements GooglepayService {

	@Autowired
	GooglepayRepository googlepayRepository;
	
	
	public Googlepay registerGooglepay(@RequestBody Googlepay googlepay) {

		Googlepay gpay = new Googlepay();
		BeanUtils.copyProperties(googlepay, gpay);
		return googlepayRepository.save(gpay);
	}

	@Override
	public List<GooglepayTransfer> generateStatement(String phoneNumber) {
		Pageable paging = PageRequest.of(0, 5);
		return googlepayRepository.generateStatement(phoneNumber,paging);

	}

	@Override
	public Googlepay getGooglepayById(Long gpayId) throws AccountNotFoundException {
		Optional<Googlepay> googlepay = googlepayRepository.findById(gpayId);
		if(googlepay.isPresent()) {
			return googlepay.get();
		}else {
			throw new AccountNotFoundException("Account Not found");
		}
		
	}

		//return null;
}


