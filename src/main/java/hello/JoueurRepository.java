package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JoueurRepository extends CrudRepository<Joueur,Long>{
	//List<Joueur> findAllByOrderByTop10MeilleurScore();
	Joueur findByJoueurId(long joueurId);
	List<Joueur> findAllByOrderByMeilleurScoreDesc();
	@SuppressWarnings("unchecked")
	Joueur save (Joueur persisted);
}
