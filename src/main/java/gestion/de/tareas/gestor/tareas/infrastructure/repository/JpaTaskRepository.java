package gestion.de.tareas.gestor.tareas.infrastructure.repository;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskRequest;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaTaskRepository extends JpaRepository<TaskEntity,Long> {

    List<TaskEntity> findByUserId(Long userId);
}
