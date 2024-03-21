package ru.skypro.diplomawork.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.skypro.diplomawork.dto.NewPasswordDto;
import ru.skypro.diplomawork.dto.RegisterReqDto;
import ru.skypro.diplomawork.dto.Role;
import ru.skypro.diplomawork.entity.User;
import ru.skypro.diplomawork.exceptions.UserHasNoRightsException;
import ru.skypro.diplomawork.repository.UserRepository;
import ru.skypro.diplomawork.security.MyUserDetailsService;
import ru.skypro.diplomawork.security.MyUserPrincipal;
import ru.skypro.diplomawork.service.AuthService;
import ru.skypro.diplomawork.service.UserService;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final MyUserDetailsService manager;

    private final PasswordEncoder encoder;
    private final UserService userService;

    private final UserRepository userRepository;


    public AuthServiceImpl(MyUserDetailsService manager, UserService userService,
                           UserRepository userRepository, PasswordEncoder encoder) {
        this.manager = manager;
        this.userService = userService;
        this.encoder = encoder;
        this.userRepository = userRepository;
    }

    /**
     * Check if user can log in
     *
     * @param userName username from a client
     * @param password password from a client
     * @return boolean result of login
     */
    @Override
    public boolean login(String userName, String password) {
        UserDetails userDetails = manager.loadUserByUsername(userName);
        String encryptedPassword = userDetails.getPassword();
        return encoder.matches(password, encryptedPassword);
    }

    /**
     * New user registration
     *
     * @param registerReqDto new user credentials from a client
     * @param role user role
     * @return boolean result of registration
     */
    @Override
    public boolean register(RegisterReqDto registerReqDto, Role role) {
        Optional<User> userByUsername = userRepository.findUserByUsername(registerReqDto.getUsername());
        if (userByUsername.isPresent()) {
            return false;
        }

        User savedUser = new User();
        savedUser.setUsername(registerReqDto.getUsername());
        savedUser.setPassword(encoder.encode(registerReqDto.getPassword()));
        savedUser.setFirstName(registerReqDto.getFirstName());
        savedUser.setLastName(registerReqDto.getLastName());
        savedUser.setPhone(registerReqDto.getPhone());
        savedUser.setRole(role);

        userRepository.save(savedUser);
        return true;
    }

    /***
     * Change password for user
     *  @param passwordDto dto with old and new passwords from a client
     * @param userPrincipal authentication instance from controller*/
    @Override
    public void changePassword(NewPasswordDto passwordDto, MyUserPrincipal userPrincipal) {
        String encryptedPassword = userPrincipal.getPassword();
        if (encoder.matches(passwordDto.getCurrentPassword(), encryptedPassword)) {
            User user = userPrincipal.getUser();
            user.setPassword(encoder.encode(passwordDto.getNewPassword()));
            userRepository.save(user);
        } else {
            throw new UserHasNoRightsException("User inputs wrong current password");
        }
    }
}
