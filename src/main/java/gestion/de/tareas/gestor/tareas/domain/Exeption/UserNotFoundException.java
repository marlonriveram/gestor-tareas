package gestion.de.tareas.gestor.tareas.domain.Exeption;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
