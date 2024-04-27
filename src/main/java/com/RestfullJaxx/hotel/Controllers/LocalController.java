package com.RestfullJaxx.hotel.Controllers;

import com.RestfullJaxx.hotel.Entities.Local;
import com.RestfullJaxx.hotel.Error.LocalNotFoundException;
import com.RestfullJaxx.hotel.Services.LocalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocalController {

    private LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }
    @GetMapping("/encontrarTodos")
    public List<Local>findAllLocals(){
        return localService.findAllLocals();
    }

    @GetMapping("/buscarPorId/{id}")
    public Local LocalencontrarPorId(@PathVariable Long id) throws LocalNotFoundException {
        return localService.findLocalById(id);

    }
    @GetMapping("/buscarPorNombre/{name}")
    public Optional<Local>encontrarPorNombre(@PathVariable String name){
        return localService.findByNameIgnoreCase(name);

    }

    @GetMapping("/buscarPorPiso/{floor}")
    public Optional<Local>encontrarPorfloor(@PathVariable String floor){
        return localService.findeByFloorIgnore(floor);

    }

    @GetMapping("/buscarPorCodigo/{code}")
    public Optional<Local>encontrarPorcode(@PathVariable String code){
        return localService.findByCodeIgnore(code);

    }
    @PostMapping("/crearLocal")
    public Local crearLocal(@Valid @RequestBody Local local){
        return localService.guardarLocal(local);

    }

    @PutMapping("/editar/{id}")
    public Local editarLocal(@PathVariable Long id, @RequestBody Local local){
        return localService.editarLocal(id, local);
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarPorId(@PathVariable Long id){
        localService.borrarLocal(id);
        return "Local eliminado";

    }






}
