package com.empresa.porhacer.service;

import com.empresa.porhacer.exceptions.PorHacerExceptions;
import com.empresa.porhacer.mapper.TaskInDtoToTask;
import com.empresa.porhacer.persistence.entity.Task;
import com.empresa.porhacer.persistence.entity.TaskStatus;
import com.empresa.porhacer.persistence.repository.TaskRepository;
import com.empresa.porhacer.service.dto.TaskInDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.PrinterException;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    //El servicio se conecta al repositorio y el repositorio a la base de datos
    //Inyección de dependencias nos ayuda a inyectar el objeto de una clase en otra
    @Autowired
    private final TaskRepository repository;
    private final TaskInDtoToTask mapper;

    //Inyección de dependecias basadas en constructor (Es una buena práctica, facilita testeo)
    //También se puede hacer con la notación @Autowired
    public TaskService(TaskRepository repository, TaskInDtoToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDto taskInDto) {
        //Para guardar datos en Spring usando JPA lo hacemos usando reposirory
        Task task = mapper.map(taskInDto);
        return this.repository.save(task);
    }

    //Nos permite obtener todas las tareas
    public List<Task> findTasks() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new PorHacerExceptions("TAREA NO ENCONTRADA", HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

//    public void deleteById(Long id) {
//        Optional<Task> optionalTask = this.repository.findById(id);
//        if (optionalTask.isEmpty()) {
//            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
//        }
//
//        this.repository.deleteById(id);
//    }


}
