package hello;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends PagingAndSortingRepository<Article,Long>{
	List<Article> findByNom( String nom);
	Article findByArticleId(long id);
	List<Article> findByType(String type);
	List<Article> findAll();
	@SuppressWarnings("unchecked")
	Article save(Article saved);
	//void delete (Article deleted);
}
