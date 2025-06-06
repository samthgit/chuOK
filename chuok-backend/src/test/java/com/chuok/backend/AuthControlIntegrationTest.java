package com.chuok.backend;

import com.chuok.backend.model.Role;
import com.chuok.backend.payload.AuthRequest;
import com.chuok.backend.payload.RegisterRequest;
import com.chuok.backend.repository.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControlIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;  // Para convertir objetos a JSON

    @Test
    public void testRegisterAndLogin() throws Exception {
        // Generar email único para evitar conflictos
        String uniqueEmail = "test" + System.currentTimeMillis() + "@example.com";

        // 1. Crear registro con email único
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setUsername("testuser");
        registerRequest.setEmail(uniqueEmail);
        registerRequest.setPassword("password123");

        mockMvc.perform(post("/api/auth/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());

        // 2. Intentar login con el usuario creado usando el mismo email único
        AuthRequest loginRequest = new AuthRequest();
        loginRequest.setEmail(uniqueEmail);
        loginRequest.setPassword("password123");

        mockMvc.perform(post("/api/auth/login")  // Corregí endpoint a login
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Autowired
    private RoleRepository roleRepository;

    @BeforeEach
    public void setup() {
        if (roleRepository.findByName("USER").isEmpty()) {
            Role role = new Role();
            role.setName("USER");
            roleRepository.save(role);
        }
    }

}
