package com.nosipo.alfrescoclothing.repository.accessories;


import com.nosipo.alfrescoclothing.domain.accessories.Bangles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BanglesRepository extends CrudRepository<Bangles,Long> {
}
