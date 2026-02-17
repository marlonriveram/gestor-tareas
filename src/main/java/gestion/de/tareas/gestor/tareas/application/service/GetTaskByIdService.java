package gestion.de.tareas.gestor.tareas.application.service;
import gestion.de.tareas.gestor.tareas.domain.Exeption.TaskNotFoundException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTaskByIdService {

    private final TaskRepository taskRepository;

    public Task getById (Long id) {

        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " was not found"));
    }
}
