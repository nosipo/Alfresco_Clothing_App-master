package com.nosipo.alfrescoclothing.services.dresses.impl;


import com.nosipo.alfrescoclothing.domain.dresses.PartyDress;
import com.nosipo.alfrescoclothing.repository.dresses.PartyDressRepository;
import com.nosipo.alfrescoclothing.services.dresses.PartyDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyDressServiceImpl implements PartyDressService {

    @Autowired
    private PartyDressRepository repository;

    @Override
    public PartyDress create(PartyDress entity) {
        return repository.save(entity);
    }

    @Override
    public PartyDress readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<PartyDress> readAll() {
        Iterable<PartyDress> result = repository.findAll();
        return result;
    }

    @Override
    public PartyDress update(PartyDress entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(PartyDress entity) {
        repository.delete(entity);
    }
}
