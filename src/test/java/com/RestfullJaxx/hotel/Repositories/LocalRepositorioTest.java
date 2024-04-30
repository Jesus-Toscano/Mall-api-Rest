package com.RestfullJaxx.hotel.Repositories;

import com.RestfullJaxx.hotel.Entities.Local;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LocalRepositorioTest {

  @Autowired
   LocalRepositorio repositorio;



    @Autowired
    TestEntityManager testEntityManager;



    @BeforeEach
    void setUp() {
        Local local = Local.builder()
                .name("Veterinaria Viri")
                .floor("Segundo piso")
                .code("l-002").build();
        testEntityManager.persist(local);

    }

    @Test
    public void findByNameIgnoreCaseFound(){
        Optional<Local>local = repositorio.findByNameIgnoreCase("Veterinaria Viri");
        assertEquals(local.get().getName(), "Veterinaria Viri");
        System.out.println("local.get = " + local.get());

    }
    @Test
    public void findLocalByNameIgnoreCaseNotFound(){
        Optional<Local> local = repositorio.findByNameIgnoreCase("Carniceria");
       assertEquals(local, Optional.empty());

    }








}