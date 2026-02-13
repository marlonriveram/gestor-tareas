package gestion.de.tareas.gestor.tareas.domain.repository;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskRequest;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    CreateTaskRequest save (CreateTaskRequest task) ;

    Optional<CreateTaskRequest> task ( Long id);

    List<CreateTaskRequest> findByUserId(Long userId);

    String deleteById (Long id);



}
