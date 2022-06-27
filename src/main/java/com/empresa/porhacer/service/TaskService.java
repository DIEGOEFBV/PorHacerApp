package com.empresa.porhacer.service;

import com.empresa.porhacer.mapper.TaskInDtoToTask;
import com.empresa.porhacer.persistence.entity.Task;
import com.empresa.porhacer.persistence.entity.TaskStatus;
import com.empresa.porhacer.persistence.repository.TaskRepository;
import com.empresa.porhacer.service.dto.TaskInDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateTaskAsFinished(Long id){
        this.repository.markTaskAsFinished(id);
    }
}
