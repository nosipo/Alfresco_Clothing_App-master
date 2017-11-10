package com.nosipo.alfrescoclothing.repository.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.HighwaistJean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HighwaistJeanRepository extends CrudRepository<HighwaistJean,Long> {
}
