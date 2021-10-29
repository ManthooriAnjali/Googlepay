package com.gpay.Googlepay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gpay.Googlepay.entity.GooglepayTransfer;

public interface GooglepayTransferRepository extends JpaRepository<GooglepayTransfer,Long> {
	
	 public GooglepayTransfer save(GooglepayTransfer gpay);

}
