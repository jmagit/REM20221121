package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.domains.entities.Actor;
import com.example.domains.entities.dtos.ActorDTO;
import com.example.domains.entities.dtos.ActorShort;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {
	List<Actor> findTop5ByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	List<Actor> findTop5ByFirstNameStartingWith(String prefijo, Sort orden);
	
	List<Actor> findByActorIdGreaterThan(int inicia);
	@Query("SELECT a FROM Actor a WHERE a.actorId > ?1")
	List<Actor> findNovedadesJPQL(int inicia);
	@Query(value = "SELECT * FROM actor a WHERE a.actor_id > ?1", nativeQuery = true)
	List<Actor> findNovedadesSQL(int inicia);

	List<ActorDTO> getByActorIdGreaterThan(int inicia);
	List<ActorShort> readByActorIdGreaterThan(int inicia);
	
	<T> List<T> findAllBy(Class<T> tipo);
}
