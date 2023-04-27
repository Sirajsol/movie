package com.example.demo.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.repository.actorrepository;
import com.example.demo.service.ActorService;
@CrossOrigin("*")
@RestController
@RequestMapping("actor")
public class ActorController {
private ActorService as;

public ActorController(ActorService as) {
	super();
	this.as = as;
}
@PostMapping("save")
public Actor save(@RequestBody Actor a) {
	return as.save(a);
}

@PostMapping("ssv")
public Actor savee(@RequestParam("fl") MultipartFile fl, @RequestParam("ast") String[] ast) {
	
	Actor ac=new Actor();
	try {
	ac.setName(ast[0]);
	ac.setAge(Integer.parseInt(ast[1]));
	ac.setImgdata(Base64.getEncoder().encodeToString(fl.getBytes()));
	
	}

	catch(IOException e) {}
	return as.save(ac);
	
}
@GetMapping("all")
public List<Actor>findthem(){
	return as.findAll();
}
@GetMapping("/{name}")
public Actor findnm( @PathVariable String name){
	return as.findByName(name);
}
@PutMapping("{actid}/{movid}")
public Actor assign(@PathVariable long actid,@PathVariable long movid ){
	return as.assign(actid, movid);
	
}
@PutMapping("deassign/{actid}/{movid}")
public Actor deassign(@PathVariable long actid,@PathVariable long movid ){
	return as.deassign(actid, movid);
	
}

@GetMapping("actor/{id}")
public Set<String>moviesPerActor(@PathVariable long id){
	return as.getMoviesActor(id);
}


@GetMapping("id/{id}")
public Actor getActor(@PathVariable long id){
	return as.findById(id);
}
@GetMapping("actor/actor/{id}")
public Set<Movie>moviesforActor(@PathVariable long id){
	Actor ac=as.findById(id);
	return ac.getMovies();
}
@PutMapping("/{id}")
public Actor updateActor(@PathVariable long id,@RequestBody Actor a) {
	return as.update(id,a);
	
	
}

}
