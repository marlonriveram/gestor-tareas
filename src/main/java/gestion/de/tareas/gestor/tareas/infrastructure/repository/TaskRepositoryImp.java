package gestion.de.tareas.gestor.tareas.infrastructure.repository;

import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskRequest;
import gestion.de.tareas.gestor.tareas.application.dto.CreateTaskResponse;
import gestion.de.tareas.gestor.tareas.application.mapper.TaskMapper;
import gestion.de.tareas.gestor.tareas.domain.model.Task;
import gestion.de.tareas.gestor.tareas.domain.repository.TaskRepository;
import gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity.TaskEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TaskRepositoryImp implements TaskRepository {

    private JpaTaskRepository jpaTaskRepository;

    @Override
    public CreateTaskResponse save(Task task) {

        TaskEntity taskEntity = TaskMapper.toEntity(task);
        TaskEntity saved = jpaTaskRepository.save(taskEntity);

        return  TaskMapper.toDto(saved);
    }

    @Override
    public Optional<CreateTaskResponse> findById(Long id) {

        return jpaTaskRepository.findById(id).map(TaskMapper::toDto);
    }

    @Override
    public List<CreateTaskResponse> findByUserId(Long id) {


        return jpaTaskRepository.findByUserId(id).stream().map(TaskMapper::toDto).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaTaskRepository.deleteById(id);
    }
}
