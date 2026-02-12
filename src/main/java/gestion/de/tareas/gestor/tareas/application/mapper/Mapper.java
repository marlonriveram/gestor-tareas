package gestion.de.tareas.gestor.tareas.application.mapper;

import gestion.de.tareas.gestor.tareas.application.dto.UserDto;
import gestion.de.tareas.gestor.tareas.domain.model.Role;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.UserEntity;

public class Mapper {

    public static UserEntity toEntity (UserDto userDto, Role role) {

        if(userDto == null) return  null;

        return UserEntity.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .role(role)
                .build();
    }

    public static UserDto toDto (UserEntity user) {
        if(user == null) return null;

        return UserDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
