package com.empresa.porhacer.controller;

import com.empresa.porhacer.persistence.entity.Task;
import com.empresa.porhacer.service.TaskService;
import com.empresa.porhacer.service.dto.TaskInDto;
import org.springframework.web.bind.annotation.*;

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


}
