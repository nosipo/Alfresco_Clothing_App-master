package com.nosipo.alfrescoclothing.services.accessories.impl;


import com.nosipo.alfrescoclothing.domain.accessories.Earrings;
import com.nosipo.alfrescoclothing.repository.accessories.EarringsRepository;
import com.nosipo.alfrescoclothing.services.accessories.EarringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EarringsServiceImpl implements EarringsService {

    @Autowired
    private EarringsRepository repository;

    @Override
    public Earrings create(ColdBeverages entity) {
        return repository.save(entity);
    }

    @Override
    public Earrings readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<Earrings> readAll() {
        Iterable<Earrings> result = repository.findAll();
        return result;
    }

    @Override
    public Earrings update(Earrings entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Earrings entity) {
        repository.delete(entity);
    }
}
