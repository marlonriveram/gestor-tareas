package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.domain.Exeption.UnauthorizedException;
import gestion.de.tareas.gestor.tareas.domain.Exeption.UserNotFoundException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import gestion.de.tareas.gestor.tareas.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTaskByUserService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public List<Task> getByUser (Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " was not found"));


        return taskRepository.findByUserId(userId);
    }
}
