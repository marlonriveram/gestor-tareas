package gestion.de.tareas.gestor.tareas.infrastructure.repository;

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

    private final JpaTaskRepository jpaTaskRepository;

    @Override
    public Task save(Task task) {

        TaskEntity taskEntity = TaskMapper.toEntity(task);
        TaskEntity saved = jpaTaskRepository.save(taskEntity);
        Task res = TaskMapper.toDomain(saved);
        return res ;
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpaTaskRepository.findById(id).map(TaskMapper::toDomain);
    }

    @Override
    public List<Task> findByUserId(Long id) {

        return jpaTaskRepository.findByUserId(id).stream().map(TaskMapper::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        jpaTaskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {

        List<Task> tasks = jpaTaskRepository.findAll().stream().map(TaskMapper::toDomain).toList();
        return tasks;
    }
}
