package com.gpay.Googlepay.GooglepayController;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.gpay.Googlepay.controller.GooglepayController;
import com.gpay.Googlepay.entity.Googlepay;
import com.gpay.Googlepay.service.GooglepayService;

@ExtendWith(MockitoExtension.class)
public class GooglepayControllerTest {

	@InjectMocks

	GooglepayController googlepayController;

	@Mock
	GooglepayService googlepayService;

	static Googlepay googlepay = new Googlepay();
	static Googlepay request = new Googlepay();
	//static String request1 = new String();

	@BeforeAll
	public static void SetUp(){

		googlepay.setPhone("9344664563");
		googlepay.setGpayId(null);
		googlepay.setFirstName("Anjali");
		googlepay.setLastName("Goud");
		googlepay.setPhone(null);


		request.setFirstName("Anjali");
		request.setLastName("Goud");
		request.setPhone(null);

		request.setPhone("9344664563");


	}

	@Test
	public void  testRegisterGooglepay() {
		Mockito.when(googlepayService.registerGooglepay(request)).thenReturn(googlepay);

		Googlepay result = googlepayController.addGooglepay(request);
		assertEquals("Anjali", result.getFirstName());
	}
	@Test
	public void testGenerateStatement() {
		Googlepay googlepay = new Googlepay();
		googlepay.getPhone();
		Mockito.when(googlepayService.generateStatement(request.getPhone())).thenReturn(null);

		Googlepay result =  googlepayController.addGooglepay(request);
		assertEquals("9344664563",result.getPhone());

	}

}
