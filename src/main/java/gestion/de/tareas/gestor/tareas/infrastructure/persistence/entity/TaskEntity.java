package gestion.de.tareas.gestor.tareas.infrastructure.persistence.entity;

import gestion.de.tareas.gestor.tareas.domain.model.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tasks")
@Builder
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;




}
