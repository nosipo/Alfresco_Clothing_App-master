package com.nosipo.alfrescoclothing.repository.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.MaxiDress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxiDressRepository extends CrudRepository<MaxiDress,Long> {
}
