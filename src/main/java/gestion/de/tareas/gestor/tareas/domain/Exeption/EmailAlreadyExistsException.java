package gestion.de.tareas.gestor.tareas.domain.Exeption;

public class EmailAlreadyExistsException  extends RuntimeException{

    public EmailAlreadyExistsException(String email) {
        super("Email already exists: " + email);
    }
}
