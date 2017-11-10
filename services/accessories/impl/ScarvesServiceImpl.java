package com.nosipo.alfrescoclothing.services.accessories.impl;


import com.nosipo.alfrescoclothing.domain.accessories.Scarves;
import com.nosipo.alfrescoclothing.repository.accessories.ScarvesRepository;
import com.nosipo.alfrescoclothing.services.accessories.ScarvesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScarvesServiceImpl implements ScarvesService {

    @Autowired
    private ScarvesRepository repository;

    @Override
    public Scarves create(Scarves entity) {
        return repository.save(entity);
    }

    @Override
    public Scarves readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Scarves> readAll() {
        Iterable<Scarves> result = repository.findAll();
        return result;
    }

    @Override
    public Scarves update(Scarves entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Scarves entity) {
        repository.delete(entity);
    }
}
