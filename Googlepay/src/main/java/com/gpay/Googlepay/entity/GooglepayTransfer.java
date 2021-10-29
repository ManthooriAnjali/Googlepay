package com.gpay.Googlepay.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class GooglepayTransfer implements Serializable {
	@Id
	@SequenceGenerator(name = "Id", sequenceName = "GooglepayTransfer_sequence", initialValue = 200, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Id")
	private Long Id;
	
	private String fromPhoneNumber;
	
	private String toPhoneNumber;
	
	private int transferAmount;
	
	private String comments;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFromPhoneNumber() {
		return fromPhoneNumber;
	}

	public void setFromPhoneNumber(String fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}

	public String getToPhoneNumber() {
		return toPhoneNumber;
	}

	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}

	public int getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(int transferAmount) {
		this.transferAmount = transferAmount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
