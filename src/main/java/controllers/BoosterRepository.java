package controllers;


import data.Booster;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "classement", path = "classement")
public interface BoosterRepository extends PagingAndSortingRepository<Booster,Long>{
	Booster findByBoosterId(@Param("boosterId")long boosterId);
}
