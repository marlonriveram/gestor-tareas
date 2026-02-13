package gestion.de.tareas.gestor.tareas.application.mapper;

import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;
import gestion.de.tareas.gestor.tareas.domain.model.UserRole;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.UserEntity;

public class Mapper {

    public static UserEntity toEntity (RegisterUserRequest registerUserRequest, UserRole userRole) {

        if(registerUserRequest == null) return  null;

        return UserEntity.builder()
                .name(registerUserRequest.getName())
                .email(registerUserRequest.getEmail())
                .password(registerUserRequest.getPassword())
                .userRole(userRole)
                .build();
    }

    public static RegisterUserRequest toDto (UserEntity user) {
        if(user == null) return null;

        return RegisterUserRequest.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
