package gestion.de.tareas.gestor.tareas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate createAt;
    private User user;

    public void update (String title,String description,TaskStatus status) {

        if (title != null) {
            this.title = title;
        }

        if (description != null) {
            this.description = description;
        }

        if (status != null) {
            this.status = status;
        }
    }

}
