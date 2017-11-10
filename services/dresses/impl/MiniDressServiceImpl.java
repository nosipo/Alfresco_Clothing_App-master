package com.nosipo.alfrescoclothing.services.dresses.impl;


import com.nosipo.alfrescoclothing.domain.dresses.MiniDress;
import com.nosipo.alfrescoclothing.repository.dresses.MiniDressRepository;
import com.nosipo.alfrescoclothing.services.dresses.MiniDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MiniDressServiceImpl implements MiniDressService {

    @Autowired
    private MiniDressRepository repository;

    @Override
    public MiniDress create(MiniDress entity) {
        return repository.save(entity);
    }

    @Override
    public MiniDress readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<MiniDress> readAll() {
        Iterable<MiniDress> result = repository.findAll();
        return result;
    }

    @Override
    public MiniDress update(MiniDress entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(MiniDress entity) {
        repository.delete(entity);
    }
}
