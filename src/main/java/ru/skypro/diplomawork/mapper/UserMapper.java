package ru.skypro.diplomawork.mapper;

import org.mapstruct.*;
import ru.skypro.diplomawork.dto.ResponseWrapperUserDto;
import ru.skypro.diplomawork.dto.UserDto;
import ru.skypro.diplomawork.entity.User;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {

    @Mapping(source = "username", target = "email")
    UserDto userToUserDto(User user);

    @Mapping(source = "email", target = "username")
    User userDtoToUser(UserDto userDto);

    @Mapping(source = "size", target = "count")
    @Mapping(source = "userList", target = "results")
    ResponseWrapperUserDto userListToResponseWrapperUserDto(Integer size, List<User> userList);
}

