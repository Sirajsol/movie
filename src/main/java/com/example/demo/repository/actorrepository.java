package com.example.demo.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Actor;



	public interface actorrepository extends JpaRepository<Actor, Long>{
public Actor findByName(String name);
@Query(value ="SELECT DISTINCT movie.name from move.actor,move.movie INNER JOIN move.actor_movie_table \r\n"
+ " ON move.movie.id=move.actor_movie_table.movie_id where move.actor_movie_table.actor=?1",nativeQuery=true)
public Set<String>moviesforactor(long id);

	
}
