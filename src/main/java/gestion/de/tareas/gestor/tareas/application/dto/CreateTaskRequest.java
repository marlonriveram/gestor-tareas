package gestion.de.tareas.gestor.tareas.application.dto;

import gestion.de.tareas.gestor.tareas.domain.model.TaskStatus;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskRequest {

    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
