package com.RestfullJaxx.hotel.Services;

import com.RestfullJaxx.hotel.Entities.Local;
import com.RestfullJaxx.hotel.Error.LocalNotFoundException;
import com.RestfullJaxx.hotel.Repositories.LocalRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocalServiceImpl implements LocalService{

    private LocalRepositorio localRepositorio;

    public LocalServiceImpl(LocalRepositorio localRepositorio) {
        this.localRepositorio = localRepositorio;
    }

    @Override
    public List<Local> findAllLocals() {
        return localRepositorio.findAll();
    }

    @Override
    public Local guardarLocal(Local local) {
        return localRepositorio.save(local);
    }

    @Override
    public Local editarLocal(Long id, Local local) {
        Local local1 = localRepositorio.findById(id).get();
        if (Objects.nonNull(local1.getCode()) && !"".equalsIgnoreCase(local1.getCode())) {
            local1.setCode(local1.getCode());

            if (Objects.nonNull(local1.getFloor()) && !"".equalsIgnoreCase(local1.getFloor())) {
                local1.setFloor(local1.getFloor());

            }

            if (Objects.nonNull(local1.getName()) && !"".equalsIgnoreCase(local1.getName())) {
                local1.setName(local1.getName());


            }

        }
        return localRepositorio.save(local1);
    }

    @Override
    public void borrarLocal(Long id) {
        localRepositorio.deleteById(id);
    }

   /* @Override
    public Optional<Local> encontrarPorNombreConJpql(String name) {
        return localRepositorio.encontrarPorNombreConJpql(name);
    }

    @Override
    public Optional<Local> encontrarPorPisoConJpql(String floor) {
        return localRepositorio.encontrarPorPisoConJpql(floor);
    }

    @Override
    public Optional<Local> encontrarPorCodigoConJpql(String code) {
        return localRepositorio.encontrarPorCodigoConJpql(code);
    }*/

    @Override
    public Optional<Local> findByNameIgnoreCase(String name) {
        return localRepositorio.findByNameIgnoreCase(name);
    }

    @Override
    public Optional<Local> findeByFloorIgnore(String floor) {
        return localRepositorio.findByFloorIgnoreCase(floor);
    }

    @Override
    public Optional<Local> findByCodeIgnore(String code) {
        return localRepositorio.findByCodeIgnoreCase(code);
    }

    @Override
    public Local findLocalById(Long id) throws LocalNotFoundException {
        Optional<Local> local = localRepositorio.findById(id);
            if (!local.isPresent()){
                throw new LocalNotFoundException("El local no esta disponible");

            }
            return local.get();
    }
}
