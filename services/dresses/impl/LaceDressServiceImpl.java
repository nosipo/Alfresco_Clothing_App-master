package com.nosipo.alfrescoclothing.services.dresses.impl;


import com.nosipo.alfrescoclothing.domain.dresses.LaceDress;
import com.nosipo.alfrescoclothing.repository.dresses.LaceDressRepository;
import com.nosipo.alfrescoclothing.services.dresses.LaceDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaceDressServiceImpl implements LaceDressService {

    @Autowired
    private LaceDressRepository repository;

    @Override
    public LaceDress create(LaceDress entity) {
        return repository.save(entity);
    }

    @Override
    public LaceDress readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<LaceDress> readAll() {
        Iterable<LaceDress> result = repository.findAll();
        return result;
    }

    @Override
    public LaceDress update(LaceDress entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(LaceDress entity) {
        repository.delete(entity);
    }
}
