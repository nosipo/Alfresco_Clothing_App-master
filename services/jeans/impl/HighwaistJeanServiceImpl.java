package com.nosipo.alfrescoclothing.services.jeans.impl;


import com.nosipo.alfrescoclothing.domain.jeans.HighwaistJean;
import com.nosipo.alfrescoclothing.repository.jeans.HighwaistJeanRepository;
import com.nosipo.alfrescoclothing.services.jeans.HighwaistJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HighwaistJeanServiceImpl implements HighwaistJeanService {

    @Autowired
    private HighwaistJeanRepository repository;

    @Override
    public HighwaistJean create(HighwaistJean entity) {
        return repository.save(entity);
    }

    @Override
    public HighwaistJean readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<HighwaistJean> readAll() {
        Iterable<HighwaistJean> result = repository.findAll();
        return result;
    }

    @Override
    public HighwaistJean update(PolonyGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(HighwaistJean entity) {
        repository.delete(entity);
    }
}
