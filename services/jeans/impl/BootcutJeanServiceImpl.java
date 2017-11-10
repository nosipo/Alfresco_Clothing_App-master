package com.nosipo.alfrescoclothing.services.jeans.impl;


import com.nosipo.alfrescoclothing.domain.jeans.BootcutJean;
import com.nosipo.alfrescoclothing.repository.jeans.BootcutJeanRepository;
import com.nosipo.alfrescoclothing.services.jeans.BootcutJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BootcutJeanServiceImpl implements BootcutJeanService {

    @Autowired
    private BootcutJeanRepository repository;

    @Override
    public BootcutJean create(BootcutJean entity) {
        return repository.save(entity) ;
    }

    @Override
    public BootcutJean readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<BootcutJean> readAll() {
        Iterable<BootcutJean> result = repository.findAll();
        return result;
    }

    @Override
    public BootcutJean update(BootcutJean entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(BootcutJean entity) {
        repository.delete(entity);
    }
}
