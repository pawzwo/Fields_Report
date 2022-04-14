package com.fields.fields_report.domain.User;

import com.fields.fields_report.api.UsersApi;
import com.fields.fields_report.exceptions.UserNotFoundException;
import com.fields.fields_report.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class UserController implements UsersApi {

    private final UserService userService;

    @Override
    public ResponseEntity<UserDto> createUser(UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @Override
    public ResponseEntity<Void> deleteUser(UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @Override
    public ResponseEntity<UserDto> findUserById(UUID id) {
        return ResponseEntity.ok(userService.findUserById(id).orElseThrow(UserNotFoundException::new));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(UUID id, UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }
}