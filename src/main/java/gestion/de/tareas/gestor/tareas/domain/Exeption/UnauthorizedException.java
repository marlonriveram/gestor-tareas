package gestion.de.tareas.gestor.tareas.domain.Exeption;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
