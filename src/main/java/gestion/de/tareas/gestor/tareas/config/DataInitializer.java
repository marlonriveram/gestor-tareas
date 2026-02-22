package gestion.de.tareas.gestor.tareas.config;

import gestion.de.tareas.gestor.tareas.domain.model.User;
import gestion.de.tareas.gestor.tareas.domain.model.UserRole;
import gestion.de.tareas.gestor.tareas.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        boolean adminExist = userRepository.existsByEmail("admin@admin.com");

        if(!adminExist){

            User admin = User.builder()
                    .name("Admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("admin123"))
                    .userRole(UserRole.ADMIN)
                    .build();

            userRepository.save(admin);

            System.out.println("✅ Admin user created");
        }
    }
}
