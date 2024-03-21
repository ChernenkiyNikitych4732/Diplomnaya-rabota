package ru.skypro.diplomawork.service;

import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.diplomawork.dto.ResponseWrapperUserDto;
import ru.skypro.diplomawork.dto.UserDto;
import ru.skypro.diplomawork.entity.User;

public interface UserService {

    ResponseWrapperUserDto getAllUsers();

    UserDto updateUser(UserDto userdto, String name);

    void updateUserAvatar(String username, MultipartFile file);

    byte[] getUserAvatar(long id);

    User getUser(String username);

    UserDto getUserDtoByUsername(String username);

    void checkIfUserHasPermissionToAlter(Authentication authentication, String username);
}
