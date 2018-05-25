package myapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import myapp.model.Scenario;

@Repository
public interface MusicRepository extends PagingAndSortingRepository<Scenario, Long>{

}
