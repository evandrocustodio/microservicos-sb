package br.com.evandro.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.evandro.hrpayroll.models.Payment;

@Service
public class PaymentService {

	public Payment getPayment(Long workerId, Integer days) {		
		return new Payment("JOAO", 200.00, days);		
	}
	
}
