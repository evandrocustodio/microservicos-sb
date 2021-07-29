package br.com.evandro.hrpayroll.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.evandro.hrpayroll.models.Payment;
import br.com.evandro.hrpayroll.models.Worker;
import br.com.evandro.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PayrollController {

	@Autowired
	private PaymentService service;
	
	@Autowired
	private RestTemplate rt;
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	@GetMapping(value = "/{workerid}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer days) {		
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", workerid.toString());

		Worker worker = rt.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariables);
		
		
		Payment payment = this.service.getPayment(worker, days);
		return ResponseEntity.ok(payment);

	}

}
