package com.empresa.porhacer.persistence.repository;

import com.empresa.porhacer.persistence.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {



}
