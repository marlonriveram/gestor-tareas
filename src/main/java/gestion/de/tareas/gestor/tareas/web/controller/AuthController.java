package gestion.de.tareas.gestor.tareas.web.controller;

import gestion.de.tareas.gestor.tareas.application.dto.RegisterUserRequest;
import gestion.de.tareas.gestor.tareas.application.service.RegisterUserService;
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

    @PostMapping("/register")
    public ResponseEntity<RegisterUserRequest> register (@Valid @RequestBody RegisterUserRequest userRequest) {

        RegisterUserRequest registerUser = registerUserService.registerUser(userRequest);

        return  ResponseEntity.ok(registerUser);
    }


}
