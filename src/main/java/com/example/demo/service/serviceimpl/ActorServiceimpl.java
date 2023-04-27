package com.example.demo.service.serviceimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.service.ActorService;

import  com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import  com.example.demo.repository.actorrepository;
import com.example.demo.repository.movierepository;

@Service
public class ActorServiceimpl implements ActorService{
private actorrepository ar;
private movierepository mr;
	public ActorServiceimpl(actorrepository ar , movierepository mr) {
	super();
	this.ar = ar;
	this.mr=mr;
}
	@Override
	public List<Actor> findAll() {
		// TODO Auto-generated method stub
		return ar.findAll();
	}
	
	public Actor save(Actor a) {
		// TODO Auto-generated method stub
		return ar.save(a);
	}
	@Override
	public Actor findByName(String name) {
		// TODO Auto-generated method stub
		return ar.findByName(name);
	}
	@Override
	public Actor findById(long id) {
		// TODO Auto-generated method stub
		return ar.findById(id).get();
	}
	
public Actor assign(long aid,long mid) {
	Actor act=ar.findById(aid).get();
	Set<Movie> mvs=null;
	mvs=act.getMovies();
	Movie mv=mr.findById(mid).get();
	mvs.add(mv);
	act.setMovies(mvs);
	return ar.save(act);
}


public Actor deassign(long aid,long mid) {
	Actor act=ar.findById(aid).get();
	Set<Movie> mvs=act.getMovies();
	
	
		Movie mv=mr.findById(mid).get();
		
	System.out.println("size "+mvs.size());
//	Movie mv=mr.findById(mid).get();
	mvs.remove(mv);
	System.out.println("size "+mvs.size());
	act.setMovies(mvs);
	return ar.save(act);
}

@Override
public Set<String> getMoviesActor(long id) {
	// TODO Auto-generated method stub
	return ar.moviesforactor(id);
}
public Actor update(long id,Actor a) {
	
	Actor ac=null;
	ac=ar.findById(id).get();
	ac.setName(a.getName());
	ac.setAge(a.getAge());
	return ar.save(ac);
	
}
}
