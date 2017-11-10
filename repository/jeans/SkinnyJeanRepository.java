package com.nosipo.alfrescoclothing.repository.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.SkinnyJean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkinnyJeanRepository extends CrudRepository<SkinnyJean,Long> {
}
