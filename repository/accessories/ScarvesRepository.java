package com.nosipo.alfrescoclothing.repository.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Scarves;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScarvesRepository extends CrudRepository<Scarves,Long> {
}
