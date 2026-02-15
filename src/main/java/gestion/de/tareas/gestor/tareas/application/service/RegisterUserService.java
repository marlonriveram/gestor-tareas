package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;
import gestion.de.tareas.gestor.tareas.application.dto.ResgisterUserResponse;
import gestion.de.tareas.gestor.tareas.application.mapper.UserMapper;
import gestion.de.tareas.gestor.tareas.domain.Exeption.EmailAlreadyExistsException;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.domain.model.UserRole;
import gestion.de.tareas.gestor.tareas.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;

    public ResgisterUserResponse registerUser (RegisterUserRequest userRequest){

        if(userRepository.existsByEmail(userRequest.getEmail())) {
            throw new EmailAlreadyExistsException(userRequest.getEmail());
        }

        User user = new User(
                null,
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPassword(),
                UserRole.USER
        );
        return userRepository.save(user);
    }
}
