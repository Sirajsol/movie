package com.example.demo.service;

import java.util.List;
import java.util.Set;

import  com.example.demo.model.Actor;

public interface ActorService {
	public List<Actor>findAll();
	public Actor save(Actor a);
	public Actor findByName(String name);
	public Actor findById(long id);
	public Actor assign(long aid,long mid) ;
	public Set<String> getMoviesActor(long id);
	public Actor update(long id,Actor a) ;
	public Actor deassign(long aid,long mid) ;
}
