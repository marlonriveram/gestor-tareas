package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskRequest;
import gestion.de.tareas.gestor.tareas.domain.Exeption.UserNotFoundException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.model.TaskStatus;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import gestion.de.tareas.gestor.tareas.domain.repository.UserRepository;
import gestion.de.tareas.gestor.tareas.infrastructure.security.CustomUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateTaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public Task createTask (CreateTaskRequest createTaskRequest, CustomUserPrincipal userPrincipal) {

        System.out.println("Creating task for user: " + userPrincipal.getRole());
        User user = userRepository.findById(userPrincipal.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + userPrincipal.getUserId() + " was not found"));

        Task task = Task.builder()
                .title(createTaskRequest.getTitle())
                .description(createTaskRequest.getDescription())
                .status(TaskStatus.PENDING)
                .user(user)
                .build();

        return taskRepository.save(task);
    }
}
