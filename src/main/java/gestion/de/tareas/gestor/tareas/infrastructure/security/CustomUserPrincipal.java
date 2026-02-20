package gestion.de.tareas.gestor.tareas.infrastructure.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomUserPrincipal {
    private final Long userId;
    private final String email;
    private final String role;

}
