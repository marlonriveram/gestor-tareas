package gestion.de.tareas.gestor.tareas.web.controller;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskRequest;
import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskResponse;
import gestion.de.tareas.gestor.tareas.application.dto.UpdateTaskRequest;
import gestion.de.tareas.gestor.tareas.application.mapper.TaskMapper;
import gestion.de.tareas.gestor.tareas.application.service.*;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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


    @PostMapping("/user/{userId}")
    public CreateTaskResponse createTask (
            @Valid @RequestBody CreateTaskRequest taskRequest,
            @PathVariable Long userId) {
        Task created = createTaskService.createTask(taskRequest,userId);

        return TaskMapper.toDto(created);
    }

    @GetMapping("user/{userId}")
    public List<CreateTaskResponse> getByUser (@PathVariable Long userId){
        List<Task> userTasks = getTaskByUserService.getByUser(userId);

        return userTasks.stream().map(TaskMapper::toDto).toList();
    }

    @GetMapping("/{taskId}")
    public CreateTaskResponse getById (@PathVariable Long taskId){
        Task task = getTaskById.getById(taskId);

        return TaskMapper.toDto(task);
    }

    @PutMapping("/{taskId}/{userId}")
    public CreateTaskResponse update (
            @RequestBody UpdateTaskRequest updateTask,
            @PathVariable Long taskId,
            @PathVariable Long userId) {
        Task updated = updateTaskService.update(updateTask,userId,taskId);

        return TaskMapper.toDto(updated);
    }

    @DeleteMapping("/{taskId}/{userId}")
    public void delete (
            @PathVariable Long taskId,
            @PathVariable Long userId) {
        deleteTaskService.delete(taskId,userId);
    }

}
