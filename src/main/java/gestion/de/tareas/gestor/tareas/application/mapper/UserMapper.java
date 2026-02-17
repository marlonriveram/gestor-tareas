package gestion.de.tareas.gestor.tareas.application.mapper;

import gestion.de.tareas.gestor.tareas.application.dto.ResgisterUserResponse;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.domain.model.UserRole;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.UserEntity;

public class UserMapper {

    public static UserEntity toEntity (User user, UserRole userRole) {

        if(user == null) return  null;

        return UserEntity.builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .userRole(userRole)
                .build();
    }

    public static ResgisterUserResponse toDto (User userEntity) {
        if(userEntity == null) return null;

        return ResgisterUserResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .userRole(userEntity.getUserRole())
                .build();
    }


    public static User toDomain (UserEntity userEntity){
        if(userEntity == null) return null;

        return User.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .userRole(userEntity.getUserRole())
                .build();
    }
}
