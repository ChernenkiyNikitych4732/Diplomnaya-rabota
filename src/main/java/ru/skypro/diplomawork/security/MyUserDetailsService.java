package ru.skypro.diplomawork.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.skypro.diplomawork.entity.User;
import ru.skypro.diplomawork.repository.UserRepository;

/**
 * Custom implementation of {@link UserDetailsService}
 * to retrieve user-related data for Spring Security Authentication process.
 */
@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final MyUserPrincipal userPrincipal;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() ->new UsernameNotFoundException(username + " not found!"));
        userPrincipal.setUser(user);
        return userPrincipal;
    }
}
