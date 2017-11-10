package com.nosipo.alfrescoclothing.services.accessories.impl;


import com.nosipo.alfrescoclothing.domain.accessories.Bangles;
import com.nosipo.alfrescoclothing.repository.accessories.BanglesRepository;
import com.nosipo.alfrescoclothing.services.accessories.BanglesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BanglesServiceImpl implements BanglesService {

    @Autowired
    private BanglesRepository repository;

    @Override
    public Bangles create(Bangles entity) {
        return repository.save(entity);
    }

    @Override
    public Bangles readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Bangles> readAll() {
        Iterable<Bangles> result = repository.findAll();
        return result;
    }

    @Override
    public Bangles update(Bangles entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Bangles entity) {
        repository.delete(entity);
    }
}
