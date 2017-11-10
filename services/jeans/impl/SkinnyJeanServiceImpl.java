package com.nosipo.alfrescoclothing.services.jeans.impl;


import com.nosipo.alfrescoclothing.domain.jeans.SkinnyJean;
import com.nosipo.alfrescoclothing.repository.jeans.SkinnyJeanRepository;
import com.nosipo.alfrescoclothing.services.jeans.SkinnyJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkinnyJeanServiceImpl implements SkinnyJeanService {

    @Autowired
    private SkinnyJeanRepository repository;

    @Override
    public SkinnyJean create(SkinnyJean entity) {
        return repository.save(entity) ;
    }

    @Override
    public SkinnyJean readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<SkinnyJean> readAll() {
        Iterable<SkinnyJean> result = repository.findAll();
        return result;
    }

    @Override
    public SkinnyJean update(SkinnyJean entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(SkinnyJean entity) {
        repository.delete(entity);
    }
}
