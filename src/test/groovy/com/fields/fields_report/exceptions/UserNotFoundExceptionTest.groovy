package com.fields.fields_report.exceptions

import com.fields.fields_report.domain.User.User
import com.fields.fields_report.domain.User.UserController
import com.fields.fields_report.domain.User.UserRepository
import com.fields.fields_report.model.Role
import com.fields.fields_report.model.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class UserNotFoundExceptionTest extends Specification {

    @Autowired
    UserRepository userRepository
    @Autowired
    UserController userController

    private UserDto userDto
    private final UUID INVALID_ID = UUID.randomUUID()


    void setup() {
        User user = new User("email@com.pl", "userName", "password", List.of(Role.ADMIN))
        userDto = userRepository.save(user).toDto()
    }

    void cleanup() {
        userRepository.deleteAll()
    }

    def "Try to find user with wrong id and get thrown UserNotFoundException"() {
        when:
        userController.findUserById(INVALID_ID)
        then:
        thrown(UserNotFoundException)
    }
}
