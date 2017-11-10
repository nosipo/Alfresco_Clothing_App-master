package com.nosipo.alfrescoclothing.services.dresses.impl;


import com.nosipo.alfrescoclothing.domain.dresses.FlaredDress;
import com.nosipo.alfrescoclothing.repository.dresses.FlaredDressRepository;
import com.nosipo.alfrescoclothing.services.dresses.FlaredDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlaredDressServiceImpl implements FlaredDressService {

    @Autowired
    private FlaredDressRepository repository;

    @Override
    public FlaredDress create(FlaredDress entity) {
        return repository.save(entity);
    }

    @Override
    public FlaredDress readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<FlaredDress> readAll() {
        Iterable<FlaredDress> result = repository.findAll();
        return result;
    }

    @Override
    public FlaredDress update(FlaredDress entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(FlaredDress entity) {
        repository.delete(entity);
    }
}
