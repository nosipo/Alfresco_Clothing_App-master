package com.nosipo.alfrescoclothing.repository.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.FlaredDress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlaredDressRepository extends CrudRepository<FlaredDress,Long> {
}
