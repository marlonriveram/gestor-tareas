package gestion.de.tareas.gestor.tareas.domain.repository;

public interface UserRepository {

    void  save () ;
    void findByEmail (String email);
    boolean existsByEmail (String email);
}
