package myapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import myapp.model.Persona;

public interface PersonaRepository extends PagingAndSortingRepository<Persona, Long>{

}
