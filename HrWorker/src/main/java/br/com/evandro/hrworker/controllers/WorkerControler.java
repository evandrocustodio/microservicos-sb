package br.com.evandro.hrworker.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;	
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.evandro.hrworker.models.Worker;
import br.com.evandro.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerControler {

	@Autowired
	private WorkerRepository repository;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Worker>> getAll() {
		List<Worker> list = this.repository.findAll();

		return ResponseEntity.ok(list);

	}

	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
		Optional<Worker> worker = this.repository.findById(id);
		return ResponseEntity.ok(worker.get());

	}

}
