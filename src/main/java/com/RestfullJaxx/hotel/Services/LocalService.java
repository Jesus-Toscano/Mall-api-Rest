package com.RestfullJaxx.hotel.Services;

import com.RestfullJaxx.hotel.Entities.Local;
import com.RestfullJaxx.hotel.Error.LocalNotFoundException;

import java.util.List;
import java.util.Optional;

public interface LocalService {

    List<Local>findAllLocals();
    Local guardarLocal(Local local);
    Local editarLocal(Long id, Local local);
    void borrarLocal(Long id);
    //CONSULTAS CON JPQL NO PERMITEN MAYUSCULAS O MINUSCULAS
   /* Optional<Local>encontrarPorNombreConJpql(String name);
    Optional<Local>encontrarPorPisoConJpql(String floor);
    Optional<Local>encontrarPorCodigoConJpql(String code);*/

    //CONSULTAS CON INVERSION DE CONTROL ES MAS FLEXIBLE, PERMITE PONER MAYUSCULAS Y MINUSCULAS
    Optional<Local>findByNameIgnoreCase(String name);
    Optional<Local>findeByFloorIgnore(String floor);
    Optional<Local>findByCodeIgnore(String code);
    Local findLocalById(Long id) throws LocalNotFoundException;



}
