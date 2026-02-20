package gestion.de.tareas.gestor.tareas.web.controller;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskRequest;
import gestion.de.tareas.gestor.tareas.application.dto.TaskResponse;
import gestion.de.tareas.gestor.tareas.application.dto.UpdateTaskRequest;
import gestion.de.tareas.gestor.tareas.application.mapper.TaskMapper;
import gestion.de.tareas.gestor.tareas.application.service.*;
import gestion.de.tareas.gestor.tareas.domain.Exeption.UnauthorizedException;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.infrastructure.security.CustomUserPrincipal;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskService createTaskService;
    private final GetTaskByUserService getTaskByUserService;
    private final GetTaskByIdService getTaskById;
    private final UpdateTaskService updateTaskService;
    private final DeleteTaskService deleteTaskService;
    private final UserByEmailService userByEmailService;



    @PostMapping
    public TaskResponse createTask (
            @Valid @RequestBody CreateTaskRequest taskRequest,
            Authentication authentication) {

        CustomUserPrincipal user =
                (CustomUserPrincipal) authentication.getPrincipal();

        Long userId = user.getUserId();

        Task created = createTaskService.createTask(taskRequest,userId);

        return TaskMapper.toDto(created);
    }

    @GetMapping
    public List<TaskResponse> getByUser (Authentication authentication){


        CustomUserPrincipal user =
                (CustomUserPrincipal) authentication.getPrincipal();

        Long userId = user.getUserId();

        List<Task> userTasks = getTaskByUserService.getByUser(userId);

        return userTasks.stream().map(TaskMapper::toDto).toList();
    }

    @GetMapping("/{taskId}")
    public TaskResponse getById (
            @PathVariable Long taskId,
            Authentication authentication
            ){
        CustomUserPrincipal user =
                (CustomUserPrincipal) authentication.getPrincipal();

        Long userId = user.getUserId();

        Task task = getTaskById.getById(taskId,userId);


        return TaskMapper.toDto(task);
    }

    @PutMapping("/{taskId}")
    public TaskResponse update (
            @RequestBody UpdateTaskRequest updateTask,
            @PathVariable Long taskId,
            Authentication authentication) {

        CustomUserPrincipal user =
                (CustomUserPrincipal) authentication.getPrincipal();

        Long userId = user.getUserId();

        Task updated = updateTaskService.update(updateTask,userId,taskId);

        return TaskMapper.toDto(updated);
    }

    @DeleteMapping("/{taskId}")
    public String delete (
            @PathVariable Long taskId,
            Authentication authentication) {

        CustomUserPrincipal user =
                (CustomUserPrincipal) authentication.getPrincipal();

        Long userId = user.getUserId();

       return deleteTaskService.delete(taskId,userId);
    }

}
