package com.RestfullJaxx.hotel.Services;

import com.RestfullJaxx.hotel.Entities.Local;
import com.RestfullJaxx.hotel.Repositories.LocalRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class LocalServiceTest {
    @Autowired
    private LocalService localService;


    @MockBean
    private LocalRepositorio localRepositorio;

    @BeforeEach
    void setUp() {
      Local local = Local.builder()
              .id(1L)
              .name("Petshop")
              .floor("segundo piso")
              .code("L-001").build();

        Mockito.when(localRepositorio.findByNameIgnoreCase("Petshop")).thenReturn(Optional.of(local));

    }
    @Test
    public void findByNameIgnoreCaseShouldFound(){
        String  LocalName = "Petshop";
        Local local = localService.findByNameIgnoreCase(LocalName).get();
        assertEquals(LocalName, local.getName());



    }



}