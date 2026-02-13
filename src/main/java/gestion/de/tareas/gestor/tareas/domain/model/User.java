package gestion.de.tareas.gestor.tareas.domain.model;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
