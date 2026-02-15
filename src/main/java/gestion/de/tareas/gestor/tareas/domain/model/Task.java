package gestion.de.tareas.gestor.tareas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private User user;
}
