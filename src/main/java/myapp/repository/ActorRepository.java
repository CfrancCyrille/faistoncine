/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.repository;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import myapp.model.Actor;

/**
 *
 * @author DeeGree
 */
@Repository
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long>{

}


