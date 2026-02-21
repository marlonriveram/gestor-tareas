package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.domain.Exeption.UnauthorizedException;
import gestion.de.tareas.gestor.tareas.domain.Exeption.UserNotFoundException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import gestion.de.tareas.gestor.tareas.domain.repository.UserRepository;
import gestion.de.tareas.gestor.tareas.infrastructure.security.CustomUserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTaskByUserService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public List<Task> getByUser (CustomUserPrincipal userPrincipal) {

        User user = userRepository.findById(userPrincipal.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User with id " + userPrincipal.getUserId() + " was not found"));

        boolean isAdmin = userPrincipal.getRole().equals("ADMIN");
        if(isAdmin){
            return taskRepository.findAll();
        }

        return taskRepository.findByUserId(userPrincipal.getUserId());
    }
}
