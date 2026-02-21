package gestion.de.tareas.gestor.tareas.domain.repository;


import gestion.de.tareas.gestor.tareas.domain.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskRepository {

    Task save (Task task) ;

    Optional<Task> findById (Long id);

    List<Task> findByUserId(Long userId);

    void deleteById (Long id);

    List<Task> findAll ();



}
