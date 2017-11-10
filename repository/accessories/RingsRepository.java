package com.nosipo.alfrescoclothing.repository.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Rings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RingsRepository extends CrudRepository<Rings,Long> {
}
