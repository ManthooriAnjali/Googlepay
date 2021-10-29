package com.gpay.Googlepay.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.GenerationType;
@Entity
public class Googlepay  implements Serializable{
	
	@Id
	@SequenceGenerator(name = "GpayId", sequenceName = "Googlepay_sequence", initialValue = 300, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GpayId")
	private Long GpayId;

	private String firstName;

	private String lastName;

	private String phone;

	

	public Long getGpayId() {
		return GpayId;
	}

	public void setGpayId(Long gpayId) {
		GpayId = gpayId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
}
