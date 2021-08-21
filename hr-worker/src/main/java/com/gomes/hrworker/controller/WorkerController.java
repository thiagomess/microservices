package com.gomes.hrworker.controller;

import java.util.List;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gomes.hrworker.controller.exceptions.ObjectNotFoundException;
import com.gomes.hrworker.entity.Worker;
import com.gomes.hrworker.repository.WorkerRepository;

import lombok.extern.slf4j.Slf4j;

@RefreshScope
@Slf4j
@RestController
@RequestMapping("/workers")
public class WorkerController {

//	@Value("${test.config}")
//	private String testConfig;
	
	private WorkerRepository workerRepository;
	
	private Environment env;

	public WorkerController(WorkerRepository workerRepository, Environment env) {
		this.workerRepository = workerRepository;
		this.env = env;
	}
	
	@GetMapping(value = "/configs")
	public ResponseEntity<Void> getConfig() {
//		log.info("CONFIG = " + testConfig);
		return ResponseEntity.noContent().build();
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workers = workerRepository.findAll();
		return ResponseEntity.ok(workers);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findAById(@PathVariable Long id) throws NotFoundException {
		log.info("PORT = " + env.getProperty("local.server.port"));
		
		/*
		try {
			System.out.println("Timeout ");
			Thread.sleep(15000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		Worker worker = workerRepository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Objeto Não encontrado: Id: " + id));
		return ResponseEntity.ok(worker);
	}

}
