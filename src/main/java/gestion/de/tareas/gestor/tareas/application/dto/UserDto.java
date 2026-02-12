package gestion.de.tareas.gestor.tareas.application.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String email;
    private String password;

}
