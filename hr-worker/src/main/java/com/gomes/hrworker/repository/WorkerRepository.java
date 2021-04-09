package com.gomes.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gomes.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
