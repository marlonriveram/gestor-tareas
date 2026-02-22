package gestion.de.tareas.gestor.tareas.application.service;

import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;
import gestion.de.tareas.gestor.tareas.domain.Exeption.EmailAlreadyExistsException;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.domain.model.UserRole;
import gestion.de.tareas.gestor.tareas.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser (RegisterUserRequest userRequest){

        if(userRepository.existsByEmail(userRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists: " + userRequest.getEmail());
        }

        String password = passwordEncoder.encode(userRequest.getPassword());

        User user = User.builder()
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .password(password)
                .userRole(UserRole.USER)
                .build();


        return userRepository.save(user);
    }
}
