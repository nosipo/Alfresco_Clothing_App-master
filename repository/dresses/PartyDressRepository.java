package com.nosipo.alfrescoclothing.repository.dresses;

import com.nosipo.alfrescoclothing.domain.dresses.PartyDress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartyDressRepository extends CrudRepository<PartyDress,Long> {
}
