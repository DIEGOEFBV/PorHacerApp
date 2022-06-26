package com.empresa.porhacer.controller;

import com.empresa.porhacer.persistence.entity.Task;
import com.empresa.porhacer.service.TaskService;
import com.empresa.porhacer.service.dto.TaskInDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDto taskInDto){
        return this.taskService.createTask(taskInDto);
    }


}
