package com.nosipo.alfrescoclothing.services.accessories.impl;


import com.nosipo.alfrescoclothing.domain.accessories.Bags;
import com.nosipo.alfrescoclothing.repository.beverages.BagsRepository;
import com.nosipo.alfrescoclothing.services.beverages.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BagsServiceImpl implements BagsService {

    @Autowired
    private BagsRepository repository;

    @Override
    public Bags create(Bags entity) {
        return repository.save(entity);
    }

    @Override
    public Bags readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Bags> readAll() {
        Iterable<Bags> result = repository.findAll();
        return result;
    }

    @Override
    public Bags update(Bags entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Bags entity) {
        repository.delete(entity);
    }
}
