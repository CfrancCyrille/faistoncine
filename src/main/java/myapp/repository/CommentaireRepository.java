package myapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import myapp.model.Commentaire;

@Repository
public interface CommentaireRepository extends PagingAndSortingRepository<Commentaire, Long>{

}
