package com.nosipo.alfrescoclothing.services.jeans.impl;


import com.nosipo.alfrescoclothing.domain.jeans.BoyfriendJean;
import com.nosipo.alfrescoclothing.repository.jeans.BoyfriendJeanRepository;
import com.nosipo.alfrescoclothing.services.jeans.BoyfriendJeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoyfriendJeanServiceImpl implements BoyfriendJeanService {

    @Autowired
    private BoyfriendJeanRepository repository;

    @Override
    public BoyfriendJean create(SteakGatsby entity) {
        return repository.save(entity);
    }

    @Override
    public BoyfriendJean readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public Iterable<BoyfriendJean> readAll() {
        Iterable<BoyfriendJean> result = repository.findAll();
        return result;
    }

    @Override
    public BoyfriendJean update(BoyfriendJean entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(BoyfriendJean entity) {
        repository.delete(entity);
    }
}
