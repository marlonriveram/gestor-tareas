package gestion.de.tareas.gestor.tareas.infrastructure.security;

import gestion.de.tareas.gestor.tareas.infrastructure.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NullMarked;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {
    private final JpaUserRepository jpaUserRepository;

    @NullMarked
    @Override
    public UserDetails loadUserByUsername( String email) throws UsernameNotFoundException {
        return jpaUserRepository.findByEmail(email)
                .map(SecurityUserAdapter::new)
                .orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
