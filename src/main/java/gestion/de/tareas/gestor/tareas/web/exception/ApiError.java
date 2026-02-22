package gestion.de.tareas.gestor.tareas.web.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Getter
@AllArgsConstructor
public class ApiError {
        private int status;
        private String error;
        private String message;

}
