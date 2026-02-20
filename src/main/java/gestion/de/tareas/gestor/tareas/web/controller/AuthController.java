package gestion.de.tareas.gestor.tareas.web.controller;

import gestion.de.tareas.gestor.tareas.application.dto.LoginRequest;
import gestion.de.tareas.gestor.tareas.application.dto.LoginResponse;
import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;
import gestion.de.tareas.gestor.tareas.application.dto.ResgisterUserResponse;
import gestion.de.tareas.gestor.tareas.application.mapper.UserMapper;
import gestion.de.tareas.gestor.tareas.application.service.LoginUserService;
import gestion.de.tareas.gestor.tareas.application.service.RegisterUserService;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUserService registerUserService;
    private final LoginUserService loginUserService;

    @PostMapping("/register")
    public ResponseEntity<ResgisterUserResponse> register (@Valid @RequestBody RegisterUserRequest userRequest) {


        User resgistered = registerUserService.registerUser(userRequest);
        ResgisterUserResponse response = UserMapper.toDto(resgistered);

        return  ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public LoginResponse login (@RequestBody LoginRequest request) {
        return loginUserService.login(request);
    }

}
