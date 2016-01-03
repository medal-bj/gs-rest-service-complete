package controllers;

import java.util.List;

import data.Joueur;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(collectionResourceRel = "joueurs", path = "joueurs")
public interface JoueurRepository extends PagingAndSortingRepository<Joueur,Long>{
	List<Joueur> findByClassementGreaterThan(@Param("classement") long classement);
	List<Joueur> findByClassementLessThan(@Param("classement") long classement);
	List<Joueur> findByClassementBetween(@Param("classementSup") long classementSup,@Param("classementInf") long classementInf);
	Joueur findByJoueurId(@Param("joueurId")long joueurId);
	 List<Joueur> findByJoueurIdOrderByMeilleurScoreDesc(@Param("id")long id);
}
