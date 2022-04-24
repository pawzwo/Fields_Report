package com.fields.fields_report;

import com.fields.fields_report.domain.User.User;
import com.fields.fields_report.domain.User.UserRepository;
import com.fields.fields_report.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StartupLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (userRepository.findByUserName("adminUser").isEmpty()) {
            User initialUser = new User("email", "adminUser", passwordEncoder.encode("adminPassword"), List.of(Role.ADMIN));
            userRepository.save(initialUser);
        }


    }
}
