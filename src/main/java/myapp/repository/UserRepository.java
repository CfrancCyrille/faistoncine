package myapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import myapp.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository <User, Long>{

}
