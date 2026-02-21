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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
            @AuthenticationPrincipal CustomUserPrincipal user) {

        Task created = createTaskService.createTask(taskRequest,user);

        return TaskMapper.toDto(created);
    }

    @GetMapping
    public List<TaskResponse> getByUser (@AuthenticationPrincipal CustomUserPrincipal userId){


        List<Task> userTasks = getTaskByUserService.getByUser(userId);

        return userTasks.stream().map(TaskMapper::toDto).toList();
    }

    @GetMapping("/{taskId}")
    public TaskResponse getById (
            @PathVariable Long taskId,
            @AuthenticationPrincipal CustomUserPrincipal user
            ){

        Task task = getTaskById.getById(taskId,user);


        return TaskMapper.toDto(task);
    }

    @PutMapping("/{taskId}")
    public TaskResponse update (
            @RequestBody UpdateTaskRequest updateTask,
            @PathVariable Long taskId,
            @AuthenticationPrincipal CustomUserPrincipal user) {


        Task updated = updateTaskService.update(updateTask,user,taskId);

        return TaskMapper.toDto(updated);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{taskId}")
    public String delete (
            @PathVariable Long taskId,
            @AuthenticationPrincipal CustomUserPrincipal user) {
        System.out.println("User role in delete endpoint: " + user.getRole());
       return deleteTaskService.delete(taskId,user);
    }

}
