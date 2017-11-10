package com.nosipo.alfrescoclothing.repository.dresses;


import com.nosipo.alfrescoclothing.domain.dresses.MiniDress;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniDressRepository extends CrudRepository<MiniDress,Long> {
}
