package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.domain.Exeption.TaskNotFoundException;
import gestion.de.tareas.gestor.tareas.domain.Exeption.UnauthorizedException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import gestion.de.tareas.gestor.tareas.infrastructure.security.CustomUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteTaskService {

    private final TaskRepository taskRepository;

    public String delete (Long id, CustomUserPrincipal userPrincipal) {

        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task with id " + id + " was not found"));


        /*
        if ( userPrincipal.getRole().equals("USER") &&
                !task.getUser().getId().equals(userPrincipal.getUserId())) {
            throw new UnauthorizedException("You cannot deleted this task");
        }

         */

        taskRepository.deleteById(id);
        return "task successfully removed";
    }
}
