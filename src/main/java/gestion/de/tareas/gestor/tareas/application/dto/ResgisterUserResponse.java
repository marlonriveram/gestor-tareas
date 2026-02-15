package gestion.de.tareas.gestor.tareas.application.dto;

import gestion.de.tareas.gestor.tareas.domain.model.UserRole;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResgisterUserResponse {
    private Long id;
    private String name;
    private String email;
    private UserRole userRole;
}
