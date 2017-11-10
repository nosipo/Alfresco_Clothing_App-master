package com.nosipo.alfrescoclothing.repository.jeans;


import com.nosipo.alfrescoclothing.domain.jeans.BoyfreindJean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoyfriendJeanRepository extends CrudRepository<BoyfriendJean,Long> {
}
