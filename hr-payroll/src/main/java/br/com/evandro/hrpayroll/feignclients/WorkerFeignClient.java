package br.com.evandro.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.evandro.hrpayroll.models.Worker;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8801", path = "/workers")
public interface WorkerFeignClient  {
	
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> getWorkerById(@PathVariable Long id);
}
