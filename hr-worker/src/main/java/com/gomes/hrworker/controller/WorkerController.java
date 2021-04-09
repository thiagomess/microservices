package com.gomes.hrworker.controller;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomes.hrworker.controller.exceptions.ObjectNotFoundException;
import com.gomes.hrworker.entity.Worker;
import com.gomes.hrworker.repository.WorkerRepository;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	private WorkerRepository workerRepository;

	public WorkerController(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findAById(@PathVariable Long id) throws NotFoundException {
		Worker worker = workerRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado: Id: " + id));
		return ResponseEntity.ok(worker);
	}

}
