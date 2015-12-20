package controllers;

import java.util.List;

import data.Article;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "boutique", path = "boutique")
public interface ArticleRepository extends PagingAndSortingRepository<Article,Long>{
	List<Article> findByNom(@Param("nom") String nom);
	Article findById(@Param("id")long id);
	List<Article> findByType(@Param("type")String type);
}
