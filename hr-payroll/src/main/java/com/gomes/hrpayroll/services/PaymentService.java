package com.gomes.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gomes.hrpayroll.entity.Payment;
import com.gomes.hrpayroll.entity.Worker;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${hr-worker.host}")
	private String workerHost;

	public Payment getPayment(long workerId, int days) {
		
		Map<String, Long> uriVariables = new HashMap<>();
		uriVariables.put("id", workerId);
		Worker worker = restTemplate.getForObject(workerHost + "workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
		
	}

}
