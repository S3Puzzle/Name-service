package com.CasS3.Name;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void shouldGetName() throws Exception {
        //arrange
        mvc.perform(post("/name/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Vic\",\n" +
                                "    \"email\": \"vic.esselink@gmail.com\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mvc.perform(post("/name/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Cas\",\n" +
                                "    \"email\": \"cas.esselink@gmail.com\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //act assert
        mvc.perform(get("/name/get").
                        contentType(MediaType.APPLICATION_JSON)
                        .param("email", "cas.esselink@gmail.com")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Cas"));
    }
    @Test
    void shouldAddUserLogin() throws Exception {
        mvc.perform(post("/name/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"name\": \"Cas\",\n" +
                                "    \"email\": \"cas.esselink@gmail.com\"\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Cas"))
                .andExpect(jsonPath("$.email").value("cas.esselink@gmail.com"));
    }
}
