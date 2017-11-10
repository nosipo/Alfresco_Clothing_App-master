package com.nosipo.alfrescoclothing.repository.dresses;

import com.nosipo.alfrescoclothing.domain.dresses.LaceDress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LaceDressRepository extends CrudRepository<LaceDress,Long> {
}
