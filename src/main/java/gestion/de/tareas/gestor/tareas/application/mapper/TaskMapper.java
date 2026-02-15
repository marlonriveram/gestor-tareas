package gestion.de.tareas.gestor.tareas.application.mapper;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskResponse;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.TaskEntity;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.UserEntity;


public class TaskMapper {

    public static TaskEntity toEntity (Task task ){

        UserEntity userEntity = new UserEntity();
        userEntity.setId(task.getUser().getId());

        return TaskEntity.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .user(userEntity)
                .build();
    }

    public static CreateTaskResponse toDto(TaskEntity taskEntity){
        if (taskEntity == null) return  null;

        User user = new User(
                taskEntity.getUser().getId(),
                taskEntity.getUser().getName(),
                taskEntity.getUser().getEmail(),
                taskEntity.getUser().getPassword(),
                taskEntity.getUser().getUserRole()
        );

        return CreateTaskResponse.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getStatus())
                .user(user)
                .build();
    }
}
