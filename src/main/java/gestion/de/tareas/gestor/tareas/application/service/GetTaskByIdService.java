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
public class GetTaskByIdService {

    private final TaskRepository taskRepository;

    public Task getById (Long taskId, CustomUserPrincipal userPrincipal) {

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + taskId + " was not found"));

        boolean isAdmin = userPrincipal.getRole().equals("ADMIN");
        boolean isOwner = task.getUser().getId().equals(userPrincipal.getUserId());

        if ( !isAdmin && !isOwner) {
            throw new UnauthorizedException("You cannot access this task");
        }

        return task ;
    }
}
