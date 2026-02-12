package gestion.de.tareas.gestor.tareas.domain.repository;

import gestion.de.tareas.gestor.tareas.application.dto.UserDto;
import gestion.de.tareas.gestor.tareas.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    UserDto save (UserDto userDto) ;
    Optional<UserDto> findByEmail (String email);
    boolean existsByEmail (String email);
}
