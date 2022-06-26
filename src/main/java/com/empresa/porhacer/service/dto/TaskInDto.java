package com.empresa.porhacer.service.dto;

import com.empresa.porhacer.persistence.entity.TaskStatus;

import java.time.LocalDateTime;

public class TaskInDto {
//Estos son los datos que ingresará el usuario a la hora de crear la tarea
    private String title;
    private String description;
    private LocalDateTime eta; //estimated time arrival

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEta() {
        return eta;
    }

    public void setEta(LocalDateTime eta) {
        this.eta = eta;
    }
}
