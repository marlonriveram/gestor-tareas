package gestion.de.tareas.gestor.tareas.domain.repository;

import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;

import java.util.Optional;

public interface UserRepository {

    RegisterUserRequest save (RegisterUserRequest registerUserRequest) ;
    Optional<RegisterUserRequest> findByEmail (String email);
    boolean existsByEmail (String email);
}
