package com.nosipo.alfrescoclothing.services.accessories.impl;


import com.nosipo.alfrescoclothing.domain.accessories.Rings;
import com.nosipo.alfrescoclothing.repository.accessories.RingsRepository;
import com.nosipo.alfrescoclothing.services.accessories.RingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RingsServiceImpl implements RingsService {

    @Autowired
    private RingsRepository repository;

    @Override
    public Rings create(Rings entity) {
        return repository.save(entity);
    }

    @Override
    public Rings readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Rings> readAll() {
        Iterable<Rings> result = repository.findAll();
        return result;
    }

    @Override
    public Rings update(Rings entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Rings entity) {
        repository.delete(entity);
    }
}
