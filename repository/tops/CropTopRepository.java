package com.nosipo.alfrescoclothing.repository.tops;


import com.nosipo.alfrescoclothing.domain.tops.CropTop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropTopRepository extends CrudRepository<CropTop,Long> {
}
