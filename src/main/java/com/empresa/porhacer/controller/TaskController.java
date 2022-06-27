package com.empresa.porhacer.controller;

import com.empresa.porhacer.persistence.entity.Task;
import com.empresa.porhacer.persistence.entity.TaskStatus;
import com.empresa.porhacer.service.TaskService;
import com.empresa.porhacer.service.dto.TaskInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskInDto) {
        return this.taskService.createTask(taskInDto);
    }

    @GetMapping
    public List<Task> findTasks() {
        return this.taskService.findTasks();
    }

    @GetMapping("/status/{status}")
    //con PathVariable leemos una variable que está el el path de la url
    public List<Task> findAllByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }


}
