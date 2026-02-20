package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.domain.Exeption.TaskNotFoundException;
import gestion.de.tareas.gestor.tareas.domain.Exeption.UnauthorizedException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTaskService {

    private final TaskRepository taskRepository;

    public String delete (Long id,Long userId) {

        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " was not found"));

        if (!task.getUser().getId().equals(userId)) {
            throw new UnauthorizedException("You cannot deleted this task");
        }

        taskRepository.deleteById(id);
        return "task successfully removed";
    }
}
