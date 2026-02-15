package gestion.de.tareas.gestor.tareas.domain.repository;


import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskResponse;
import gestion.de.tareas.gestor.tareas.domain.model.Task;

import java.net.CacheResponse;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    CreateTaskResponse save (Task task) ;

    Optional<CreateTaskResponse> findById (Long id);

    List<CreateTaskResponse> findByUserId(Long userId);

    void deleteById (Long id);



}
