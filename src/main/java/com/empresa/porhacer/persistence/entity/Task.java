package com.empresa.porhacer.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //Con esta notacion(La cual es una dependencia (lombok)) obtenemos de manera automatica los getters y setters de esta clase
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta; //estimated time arrival
    private boolean finished;
    private TaskStatus taskStatus;


//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public LocalDateTime getEta() {
//        return eta;
//    }
//
//    public void setEta(LocalDateTime eta) {
//        this.eta = eta;
//    }
//
//    public boolean isFinished() {
//        return finished;
//    }
//
//    public void setFinished(boolean finished) {
//        this.finished = finished;
//    }
//
//    public TaskStatus getTaskStatus() {
//        return taskStatus;
//    }
//
//    public void setTaskStatus(TaskStatus taskStatus) {
//        this.taskStatus = taskStatus;
//    }
}
