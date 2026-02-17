package gestion.de.tareas.gestor.tareas.application.dto;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateTaskRequest {

    private String title;
    private String description;
    private String status;

}
