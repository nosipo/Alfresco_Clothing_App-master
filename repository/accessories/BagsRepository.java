package com.nosipo.alfrescoclothing.repository.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Bags;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagsRepository extends CrudRepository<Bags,Long> {
}
