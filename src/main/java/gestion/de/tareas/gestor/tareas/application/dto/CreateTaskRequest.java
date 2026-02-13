package gestion.de.tareas.gestor.tareas.application.dto;

import gestion.de.tareas.gestor.tareas.domain.model.TaskStatus;
import gestion.de.tareas.gestor.tareas.domain.model.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskRequest {

    private String title;
    private String description;
    private TaskStatus status;
    private User user;
}
