package br.com.evandro.hrpayroll.controllers;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	private RestTemplate restTemplate;

	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	@GetMapping(value = "/{workerid}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerid, @PathVariable Integer days) {

		Worker worker = workerFeignClient.getWorkerById(workerid).getBody();

		Payment payment = this.service.getPayment(worker, days);
		
		return ResponseEntity.ok(payment);

	}

	
	
	@GetMapping
	public String gerar(@RequestBody String xml) {
		
		Map<String,String> parametros = new HashMap<>();
		
		parametros.put("xml", xml);
		
		Object retorno = restTemplate.postForLocation("https://azhar.webdanfe.com.br/danfe/GeraDanfe.php", String.class, parametros);
				
		return retorno.toString();		
		
	}
}
