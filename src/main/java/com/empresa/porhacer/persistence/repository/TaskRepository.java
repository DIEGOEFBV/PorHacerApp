package com.empresa.porhacer.persistence.repository;

import com.empresa.porhacer.persistence.entity.Task;
import com.empresa.porhacer.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying //Significa que la query es una query de actualización
    //@Query es una notación que permite ejecutar queries en spring y pueden ser nativas, el value es donde pondremos
    //la query que queremos ejecutar y el otro parámetro nativeQuery true o false, si es true significa que la query
    //que está en el value se va ejecutar de manera nativa eso significa que se va ejecutar en dependencia de la base
    //datos que estamos utilizando.

    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID:id;", nativeQuery = true)
    public void markTaskAsFinished(@Param("id")Long id);


}
