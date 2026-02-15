package gestion.de.tareas.gestor.tareas.infrastructure.repository;

import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;
import gestion.de.tareas.gestor.tareas.application.dto.ResgisterUserResponse;
import gestion.de.tareas.gestor.tareas.application.mapper.UserMapper;
import gestion.de.tareas.gestor.tareas.domain.model.User;
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
    public ResgisterUserResponse save(User user) {

        UserEntity userEntity = UserMapper.toEntity(user,UserRole.USER) ;
        UserEntity saved = jpaUserRepository.save(userEntity);

        return UserMapper.toDto(saved) ;
    }

    @Override
    public Optional<ResgisterUserResponse> findByEmail(String email) {

        return jpaUserRepository.findByEmail(email)
                .map(UserMapper::toDto);

    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaUserRepository.existsByEmail(email);
    }
}
