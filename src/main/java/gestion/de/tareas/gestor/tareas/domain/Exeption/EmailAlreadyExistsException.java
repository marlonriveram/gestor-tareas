package gestion.de.tareas.gestor.tareas.domain.Exeption;

public class EmailAlreadyExistsException  extends RuntimeException{

    public EmailAlreadyExistsException(String message) {
        super(message);
    }


}
