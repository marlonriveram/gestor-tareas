package gestion.de.tareas.gestor.tareas.infrastructure.repository;

import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;
import gestion.de.tareas.gestor.tareas.application.mapper.Mapper;
import gestion.de.tareas.gestor.tareas.domain.model.UserRole;
import gestion.de.tareas.gestor.tareas.domain.repository.UserRepository;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImp implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public RegisterUserRequest save(RegisterUserRequest registerUserRequest) {

        UserEntity user = Mapper.toEntity(registerUserRequest, UserRole.USER);
        UserEntity saveEntity = jpaUserRepository.save(user);

        return Mapper.toDto(saveEntity);
    }

    @Override
    public Optional<RegisterUserRequest> findByEmail(String email) {

        return jpaUserRepository.findByEmail(email)
                .map(Mapper::toDto);

    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }
}
