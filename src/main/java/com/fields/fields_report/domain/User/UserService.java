package com.fields.fields_report.domain.User;

import com.fields.fields_report.model.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    UserDto createUser(UserDto userDto);

    void deleteUser(UUID id);

    List<UserDto> findAllUsers();

    Optional<UserDto> findUserById(UUID id);

    UserDto updateUser(UUID id, UserDto userDto);

}
