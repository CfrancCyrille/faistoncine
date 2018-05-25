package myapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import myapp.model.Music;

@Repository
public interface MusicRepository extends PagingAndSortingRepository<Music, Long>{

}
