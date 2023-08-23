package de.ait.final_project.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@DisplayName("Registration is works")
public class RegistrationControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void registerMethodReturnsCreated() throws Exception {
        mockMvc.perform(post("/api/registration")
                .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"fullName\": \"Jackie Chan\",\n" +
                                "  \"email\": \"example@mail.com\",\n" +
                                "  \"password\": \"Qwerty123!\",\n" +
                                "  \"town\": \"Hamburg, Norbert-Schmid-Platz 11\",\n" +
                                "  \"street\": \"Norbert-Schmid-Platz\",\n" +
                                "  \"houseNumber\": \"11\",\n" +
                                "  \"phoneNumber\": \"+4917611223344!\"\n" +
                                "}"))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
