package com.nosipo.alfrescoclothing.repository.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.BootcutJean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootcutJeanRepository extends CrudRepository<BootcutJean,Long> {
}
