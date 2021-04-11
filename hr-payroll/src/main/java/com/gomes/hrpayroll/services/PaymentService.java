package com.gomes.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.gomes.hrpayroll.entity.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob", 200.0	, days);
		
	}
	
	

}
