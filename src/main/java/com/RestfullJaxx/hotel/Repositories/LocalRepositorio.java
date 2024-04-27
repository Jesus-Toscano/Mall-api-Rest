package com.RestfullJaxx.hotel.Repositories;

import com.RestfullJaxx.hotel.Entities.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface LocalRepositorio  extends JpaRepository<Local, Long> {

//CONSULTAS POR JPQL
   /* @Query("SELECT l FROM Local l WHERE l.name = :name" )
    Optional<Local>encontrarPorNombreConJpql(String name);

    @Query("SELECT l FROM Local l WHERE l.floor = :floor" )
    Optional<Local>encontrarPorPisoConJpql(String floor);
    @Query("SELECT l FROM Local l WHERE l.code = :code" )
    Optional<Local>encontrarPorCodigoConJpql(String code);*/


    Optional<Local>findByName(String name);
    Optional<Local>findByNameIgnoreCase(String name);
    Optional<Local>findByFloorIgnoreCase(String floor);
    Optional<Local>findByCodeIgnoreCase(String code);

}
