package com.gomes.hrpayroll.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomes.hrpayroll.entity.Payment;
import com.gomes.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
		
	}

}
