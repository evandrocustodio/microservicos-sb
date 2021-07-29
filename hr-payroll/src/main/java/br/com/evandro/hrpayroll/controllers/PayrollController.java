package br.com.evandro.hrpayroll.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evandro.hrpayroll.models.Payment;
import br.com.evandro.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PayrollController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping(value="/{worker}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long worker, @PathVariable Integer days){		
		Payment payment = this.service.getPayment(worker, days);		
		return ResponseEntity.ok(payment);
		
	}
	

}
