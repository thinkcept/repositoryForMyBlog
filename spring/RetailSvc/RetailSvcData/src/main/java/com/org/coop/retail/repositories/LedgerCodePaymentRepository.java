package com.org.coop.retail.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.coop.retail.entities.LedgerCodePayment;

public interface LedgerCodePaymentRepository extends JpaRepository<LedgerCodePayment, Integer> {
	
	public LedgerCodePayment findByPaymentType(String paymentType); 
}
