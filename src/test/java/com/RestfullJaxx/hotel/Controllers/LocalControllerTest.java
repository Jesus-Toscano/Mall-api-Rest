package com.RestfullJaxx.hotel.Controllers;

import com.RestfullJaxx.hotel.Entities.Local;
import com.RestfullJaxx.hotel.Error.LocalNotFoundException;
import com.RestfullJaxx.hotel.Repositories.LocalRepositorio;
import com.RestfullJaxx.hotel.Services.LocalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LocalController.class)
class LocalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LocalService localService;

    private Local local;
    @BeforeEach
    void setUp() {
        local = Local.builder()
                .id(1L)
                .name("Toscano")
                .floor("Primer Piso")
                .code("L-001").build();
    }
    @Test
    public void saveLocal() throws Exception {
        Local postLocal = Local.builder()
                .name("Toscano")
                .floor("Primer Piso")
                .code("L-001").build();

        Mockito.when(localService.guardarLocal(postLocal)).thenReturn(local);
        mockMvc.perform(post("/crearLocal").contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                                "   \"name\":\"Toscano\", \n" +
                        "  \"floor\":\"Primer Piso\", \n" +
                        "   \"code\": \"L-001\"\n "+

                        "}"))
                .andExpect(status().isOk());


    }
    @Test
    public void findLocalById() throws Exception {
        Mockito.when(localService.findLocalById(1L)).thenReturn(local);
        mockMvc.perform(get("/buscarPorId/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name").value(local.getName()));

    }


}