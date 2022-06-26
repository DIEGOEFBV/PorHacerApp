package com.empresa.porhacer.mapper;

import com.empresa.porhacer.persistence.entity.Task;
import com.empresa.porhacer.persistence.entity.TaskStatus;
import com.empresa.porhacer.service.dto.TaskInDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

//Este mapper lo vamos ausar en las clases que necesitemos, por lo tanto lo pondremos como
//un Componente de spring para poder inyectarlo en otras clases
@Component
public class TaskInDtoToTask implements IMapper<TaskInDto, Task> {

    @Override
    public Task map(TaskInDto in) {
        Task task = new Task();
        //Atributos que tenemos en el dto
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        //Tambien necesitamos los otros atributos. Lo haremos de manera directa
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
