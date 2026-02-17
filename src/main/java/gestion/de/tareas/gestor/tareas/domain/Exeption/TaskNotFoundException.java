package gestion.de.tareas.gestor.tareas.domain.Exeption;

public class TaskNotFoundException extends  RuntimeException{

    public  TaskNotFoundException (String message){
        super(message);
    }
}
