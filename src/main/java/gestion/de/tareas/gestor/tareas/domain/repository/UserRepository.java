package gestion.de.tareas.gestor.tareas.domain.repository;

import gestion.de.tareas.gestor.tareas.application.dto.ResgisterUserResponse;
import gestion.de.tareas.gestor.tareas.domain.model.User;

import java.util.Optional;

public interface UserRepository {

    ResgisterUserResponse save (User user) ;

    Optional<ResgisterUserResponse> findByEmail (String email);

    boolean existsByEmail (String email);

}
