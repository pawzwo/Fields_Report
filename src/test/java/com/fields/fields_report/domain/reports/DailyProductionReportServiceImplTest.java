package com.fields.fields_report.domain.reports;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fields.fields_report.domain.User.User;
import com.fields.fields_report.domain.User.UserRepository;
import com.fields.fields_report.model.UserDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DailyProductionReportServiceImplTest {

    private final String userName = "admin";
    private final SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;

    private UserDto userDto;
    private List<User> users;

    @BeforeAll
    void setUp() {

    }

    @AfterAll
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void saveDailyReport() {
    }
}