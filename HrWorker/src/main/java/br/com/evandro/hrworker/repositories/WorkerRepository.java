package br.com.evandro.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.evandro.hrworker.models.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
