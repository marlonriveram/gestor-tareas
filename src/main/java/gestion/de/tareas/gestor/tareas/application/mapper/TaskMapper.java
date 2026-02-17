package gestion.de.tareas.gestor.tareas.application.mapper;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskResponse;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.TaskEntity;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.UserEntity;


public class TaskMapper {

    public static TaskEntity toEntity (Task task ){

        UserEntity userEntity = null;
        if (task.getUser() != null) {

            userEntity = UserEntity.builder()
                    .id(task.getUser().getId())
                    .name(task.getUser().getName())
                    .email(task.getUser().getEmail())
                    .userRole(task.getUser().getUserRole())
                    .build();
        }

        return TaskEntity.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .user(userEntity)
                .build();
    }

    public static CreateTaskResponse toDto(Task task){
        if (task == null) return  null;

        User user = null;

        if (task.getUser() != null) {

            user = User.builder()
                    .id(task.getUser().getId())
                    .name(task.getUser().getName())
                    .email(task.getUser().getEmail())
                    .userRole(task.getUser().getUserRole())
                    .build();
        }
        return CreateTaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .user(user)
                .build();
    }

    public static Task toDomain ( TaskEntity taskEntity){

        if(taskEntity == null) return null;

        User user = null;

        if (taskEntity.getUser() != null) {

            user = User.builder()
                    .id(taskEntity.getUser().getId())
                    .name(taskEntity.getUser().getName())
                    .email(taskEntity.getUser().getEmail())
                    .userRole(taskEntity.getUser().getUserRole())
                    .build();

        }
        return Task.builder()
                .id(taskEntity.getId())
                .title(taskEntity.getTitle())
                .description(taskEntity.getDescription())
                .status(taskEntity.getStatus())
                .createAt(taskEntity.getCreateAt())
                .user(user)
                .build();
    }
}
