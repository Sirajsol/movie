package com.example.demo.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Actor;
import  com.example.demo.model.Movie;

public interface MovieService {
public List<Movie> findAll();
public Movie save(Movie m);
public Movie findname (String nm);
public Movie assign(long mid,long aid);
//public Set<Actor> assign(long mid,long aid);
public Set<String>mNames();
public Set<String> getActorsMovie(long id);
public Set<Object>allactors(long id);
public String[]iallactors(long id);
public Set<Movie>namelike(String name);
public Movie movieById(long id);
public Movie update(long id,Movie m );

public Set<Movie>moviesByYear(int year);
public Set<Movie>moviesByGener(String gener);
public Set<Movie>moviesByRate(int rate);
public int[]Years();
//to get actors to add to the movie in movie age
public Set<Object>allactorstoadd();
//public int delete(long id);
public  boolean delete( long id) ;
Page<Movie> findAll(Pageable pageable);
}
