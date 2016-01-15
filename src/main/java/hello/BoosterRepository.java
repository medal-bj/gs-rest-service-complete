package hello;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "boosters", path = "boosters")
public interface BoosterRepository extends PagingAndSortingRepository<Booster,Long>{
	Booster findByBoosterId(@Param("boosterId")long boosterId);
}
