package ru.skypro.diplomawork.service;

import ru.skypro.diplomawork.dto.NewPasswordDto;
import ru.skypro.diplomawork.dto.RegisterReqDto;
import ru.skypro.diplomawork.dto.Role;
import ru.skypro.diplomawork.security.MyUserPrincipal;

public interface AuthService {
    boolean login(String userName, String password);
    boolean register(RegisterReqDto registerReqDto, Role role);

    void changePassword(NewPasswordDto passwordDto, MyUserPrincipal userPrincipal);
}
