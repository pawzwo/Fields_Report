package com.fields.fields_report.domain.User;

import com.fields.fields_report.domain.ProtoDocument;
import com.fields.fields_report.model.Role;
import com.fields.fields_report.model.UserDto;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.List;


@Document
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends ProtoDocument {

    private String email;
    private String userName;
    private String password;

    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    public UserDto toDto() {
        UserDto userDto = new UserDto();
        userDto.setId(this.getId());
        userDto.email(this.getEmail());
        userDto.userName(this.getUserName());
        userDto.password(this.getPassword());
        userDto.roles(this.getRoles());
        return userDto;
    }

    public User updateUser(UserDto userDto) {
        this.email= userDto.getEmail();
        this.userName = userDto.getUserName();
        this.password = userDto.getPassword();
        this.roles = userDto.getRoles();
        return this;
    }

}