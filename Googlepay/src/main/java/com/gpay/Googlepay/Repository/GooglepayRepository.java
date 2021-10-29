package com.gpay.Googlepay.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gpay.Googlepay.entity.Googlepay;
import com.gpay.Googlepay.entity.GooglepayTransfer;

import feign.Param;

public interface GooglepayRepository extends JpaRepository<Googlepay,Long> {
	public Googlepay findByPhoneEquals(String phone);
    public Googlepay save(Googlepay gpay);
	
	@Query("select c from GooglepayTransfer c WHERE c.fromPhoneNumber = :fromPhoneNumber")
	  public List<GooglepayTransfer> generateStatement(@Param("fromPhoneNumber") String fromPhoneNumber, Pageable paging);
	  
	  

}
