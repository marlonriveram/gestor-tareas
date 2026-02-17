package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.application.dto.UpdateTaskRequest;
import gestion.de.tareas.gestor.tareas.domain.Exeption.TaskNotFoundException;
import gestion.de.tareas.gestor.tareas.domain.Exeption.UnauthorizedException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.model.TaskStatus;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateTaskService {

    public final TaskRepository taskRepository;

    public Task update (UpdateTaskRequest update, Long userId, Long taskId) {


        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task with id " + taskId + " was not found"));

        //Verificar que la tarea a actualizar pertenesca al usuario

        if (!task.getUser().getId().equals(userId)){
            throw  new UnauthorizedException("You cannot modify this task");
        }

        task.update(
                update.getTitle(),
                update.getDescription(),
                // Si el status del request no es null, convertir el String a enum TaskStatus.
                // Si es null, mantenerlo como null para no modificar el estado actual.
                update.getStatus() != null
                ? TaskStatus.valueOf(update.getStatus())
                : null
        );


        return  taskRepository.save(task);
    }
}
