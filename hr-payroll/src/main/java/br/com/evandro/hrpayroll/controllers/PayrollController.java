package br.com.evandro.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evandro.hrpayroll.feignclients.WorkerFeignClient;
import br.com.evandro.hrpayroll.models.Payment;
import br.com.evandro.hrpayroll.models.Worker;
import br.com.evandro.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PayrollController {

	@Autowired
	private PaymentService service;

	@Autowired
	private WorkerFeignClient workerFeignClient;

	@GetMapping(value = "/{workerid}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer days) {

		Worker worker = workerFeignClient.getWorkerById(workerid).getBody();

		Payment payment = this.service.getPayment(worker, days);
		
		return ResponseEntity.ok(payment);

	}

}
