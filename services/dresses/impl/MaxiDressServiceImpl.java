package com.nosipo.alfrescoclothing.services.dresses.impl;


import com.nosipo.alfrescoclothing.domain.dresses.MaxiDress;
import com.nosipo.alfrescoclothing.repository.dresses.MaxiDressRepository;
import com.nosipo.alfrescoclothing.services.dresses.MaxiDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaxiDressServiceImpl implements MaxiDressService {

    @Autowired
    private MaxiDressRepository repository;

    @Override
    public MaxiDress create(MaxiDress entity) {
        return repository.save(entity);
    }

    @Override
    public MaxiDress readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<MaxiDress> readAll() {
        Iterable<MaxiDress> result = repository.findAll();
        return result;
    }

    @Override
    public MaxiDress update(MaxiDress entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(MaxiDress entity) {
        repository.delete(entity);
    }
}
