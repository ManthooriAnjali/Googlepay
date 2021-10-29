package com.gpay.Googlepay.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.gpay.Googlepay.Repository.GooglepayRepository;
import com.gpay.Googlepay.entity.Googlepay;
import com.gpay.Googlepay.service.Impl.GooglepayServiceImpl;

@ExtendWith(SpringExtension.class)
public class GooglepayServiceImplTest {

	@InjectMocks
	GooglepayServiceImpl googlepayServiceImpl;

	@Mock
	GooglepayRepository googlepayRepository;

	@Test
	public void testGetGoogleByIdForPositive() throws AccountNotFoundException {

		Googlepay googlepay = new Googlepay();
		googlepay.setGpayId(1L);
		googlepay.setFirstName("Anjali");

		Mockito.when(googlepayRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(googlepay));

		Googlepay dbGooglepay =	googlepayServiceImpl.getGooglepayById(1L);

		assertNotNull(dbGooglepay);
		assertEquals("Anjali", dbGooglepay.getFirstName());


	}
	@Test
	public void testGetGooglepayByIdForException(){

		Googlepay googlepay = new Googlepay();
		googlepay.setGpayId(1L);
		googlepay.setFirstName("Anjali");

		Mockito.when(googlepayRepository.findById(2L)).thenReturn(Optional.of(googlepay));

		try {
			Googlepay dbGoogle = googlepayServiceImpl.getGooglepayById(2L);
			assertTrue(false);
		} catch (AccountNotFoundException e) {
			System.out.println("exception==========>");
			assertTrue(true);
		}
	}
}
