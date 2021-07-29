package br.com.evandro.hrpayroll.services;

import org.springframework.stereotype.Service;

import br.com.evandro.hrpayroll.models.Payment;
import br.com.evandro.hrpayroll.models.Worker;

@Service
public class PaymentService {

	public Payment getPayment(Worker worker, Integer days) {	
				
		return new Payment(worker.getName(), worker.getDailyIncome(), days);		
	}
	
}
