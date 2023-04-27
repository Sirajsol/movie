package com.example.demo.repository;

import java.util.Set;

import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;

public interface movierepository extends JpaRepository<Movie, Long>,PagingAndSortingRepository<Movie, Long>{
public Movie findByName(String name);
@Query("Select name From Actor")
public Set<String>mnames();
//movies by actor
//@Query(value ="SELECT DISTINCT movie.name from move.actor,move.movie INNER JOIN move.actor_movie_table \r\n"
//		+ " ON move.movie.id=move.actor_movie_table.movie_id where move.actor_movie_table.actor=?1",nativeQuery=true)
//public Set<String>actorsformovie(long id);
//actors by movie
@Query(value ="SELECT DISTINCT actor.name from move.movie,move.actor INNER JOIN move.actor_movie_table  \r\n"
		+ "ON move.actor.id=move.actor_movie_table.actor where move.actor_movie_table.movie_id=?1",nativeQuery=true)
public Set<String>actorsformovie(long id);
@Query(value ="SELECT DISTINCT actor.id,actor.name,actor.imgdata from move.movie,move.actor INNER JOIN move.actor_movie_table  \r\n"
		+ "ON move.actor.id=move.actor_movie_table.actor where move.actor_movie_table.movie_id=?1",nativeQuery=true)
public Set<Object>allactorsformovie(long id);

@Query(value ="SELECT actor.id,actor.name,actor.age,actor.imgdata from  move.movie,move.actor INNER JOIN move.actor_movie_table  \r\n"
		+ "ON move.actor.id=move.actor_movie_table.actor where move.actor_movie_table.movie_id=?1",nativeQuery=true)
public String[]iallactorsformovie(long id);

@Query("From Movie where name LIKE ?1%")
public Set<Movie>namelike(String name);
@Query("From Movie where year = ?1")
public Set<Movie>movieByYear(int year);
@Query("From Movie where gener = ?1")
public Set<Movie>movieByGener(String gener);
@Query("From Movie where rate >= ?1")
public Set<Movie>movieByRate(int rate);


@Query(value = "SELECT DISTINCT year from move.movie",nativeQuery=true)
public int[]Years();

@Query(value ="SELECT DISTINCT actor.id,actor.name,actor.imgdata from move.actor",nativeQuery=true)
public Set<Object>allactorstoadd();

//@SQLDelete(sql ="DELETE FROM move.actor_movie_table where movie_id=?1")
//public void delete(long id);


}
 