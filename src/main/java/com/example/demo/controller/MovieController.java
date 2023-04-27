package com.example.demo.controller;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.Double;

import com.example.demo.service.ActorService;
import com.example.demo.service.MovieService;
import com.example.demo.model.Actor;
import com.example.demo.model.Movie;
import com.example.demo.model.mreq;
@CrossOrigin("*")
@RestController
@RequestMapping("/ms")
public class MovieController {
	private MovieService ms;
	private  ActorService as;
//	@Autowired(required = true)
//	private EntityManager em;
	
	public MovieController(MovieService ms, ActorService as) {
		super();
		this.ms = ms;
		this.as = as;
	
	}
	@CrossOrigin("*")
 @PostMapping("save")
 public Movie save(@RequestBody Movie m) {
	 return ms.save(m);
 }

 @GetMapping("get")
 public int get() {
	 return 3;
 }
// @GetMapping("all")
// public List<Movie>getthem(){
//	 return ms.findAll();
// }
 @GetMapping("all")
 public Page<Movie>getthem(Pageable pageable){
	 return ms.findAll(pageable);
 }
 
 @GetMapping("{name}")
 public Movie getnm(@PathVariable String name){
	 return ms.findname(name);
 }
 @PutMapping("{mid}/{aid}")
 public Movie assign(@PathVariable long mid,@PathVariable long aid ){
// public Set<Actor> assign(@PathVariable long mid,@PathVariable long aid ){
 	return ms.assign(mid, aid);
 	
 }
 
// @PutMapping("deassign/{mid}/{aid}")
// public Movie deassign(@PathVariable long mid,@PathVariable long aid ){
//// public Set<Actor> assign(@PathVariable long mid,@PathVariable long aid ){
// 	return ms.deassign(mid, aid);
// 	
// }
 @GetMapping("mnames")
 public Set<String> mNames() {
	return ms.mNames();
 }
 @GetMapping("ms/{id}")
 public Set<String> actorsformovie(@PathVariable long id) {
	return ms.getActorsMovie(id);
 }
 @GetMapping("ma/{id}")
 public Set<Object> alm(@PathVariable long id){
	 return ms.allactors(id);
 }
 @GetMapping("name/{name}")
 public Set<Movie> namelike(@PathVariable String name) {
		// TODO Auto-generated method stub
		return ms.namelike(name);
	}
 @GetMapping("movie/{id}")
 public Movie movieById(@PathVariable long id) {
		// TODO Auto-generated method stub
		return ms.movieById(id);
	}
 @PutMapping("/{id}")
 public Movie updateMovie(@PathVariable long id,@RequestBody Movie m ) {
	return ms.update(id, m);
 }
 
 @PutMapping("withimage/{id}")
 public Movie updateMovieimage(@PathVariable long id,@RequestParam("fl") MultipartFile mp,@RequestParam("mov") String[] mv ) {
	
	 Movie m=new Movie();
	 try {
	 m.setName(mv[0]);
	 m.setGener(mv[1]);
	 m.setRate(Double.parseDouble(mv[2]));
	 m.setDescription(mv[3]);
	 m.setYear(Integer.parseInt(mv[4]));
	 m.setImgdata(Base64.getEncoder().encodeToString(mp.getBytes()));
	 }
	 catch(IOException e) {}
	 return ms.update(id, m);
 }
 
 @PostMapping("ssv")
 public String sss( @RequestParam("fl") MultipartFile mp,@RequestParam("mov") String[] mv)
 {
	 try {
		 Movie m=new Movie();
		 m.setName(mv[0]);
		 m.setGener(mv[1]);
		 m.setRate(Double.parseDouble(mv[2]));
		 m.setDescription(mv[3]);
		 m.setYear(Integer.parseInt(mv[4]));
		 m.setImgdata(Base64.getEncoder().encodeToString(mp.getBytes()));
		 ms.save(m);
		 System.out.println("is"+mp.getName());
//		 System.out.println("movie is"+mv.getName()+" id "+mv.getId());
		return mp.getName();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return null;
 }
 @GetMapping("mam/{id}")
 public Set<Actor> iactorsformovie(@PathVariable long id) {
	 Set<Actor> acts=new HashSet<Actor>();
	 String[] ob=ms.iallactors(id);
	for(int j=0;j<ob.length;j++) {
		String[]obb=ob[j].split(",");
		
		for(int i=0;i<ob.length;i++) {
			
			 Actor a=new Actor();
			 a.setId(Long.parseLong(obb[0].toString()));
			 a.setName(obb[1].toString());
			 a.setAge(Integer.parseInt(obb[2].toString()));
			 a.setImgdata(obb[3].toString());
			 
			 acts.add(a);
		 }
		
	}
			
			
			// System.out.println("1-"+Long.parseLong(obb[0].toString()));System.out.println("2-"+obb[1].toString());
			// System.out.println("3- "+Integer.parseInt(obb[2].toString()));System.out.println("4- "+obb[3].toString());
	 
	
	 
		return acts;
	 }
 
 @GetMapping("actorss")
 public Set<Object> allactorstoadd() {
	 return ms.allactorstoadd();
 }
 
 
 @GetMapping("year/{year}")
 public Set<Movie> moviesByYear(@PathVariable int year) {
	 return ms.moviesByYear(year);
 }
 @GetMapping("gener/{gener}")
 public Set<Movie> moviesByYear(@PathVariable String gener) {
	 return ms.moviesByGener(gener);
 }
 @GetMapping("rate/{rate}")
 public Set<Movie> moviesByRate(@PathVariable int rate) {
	 return ms.moviesByRate(rate);
 }
 @GetMapping("years")
 public int[]years(){
	 
	 return ms.Years();
 }
 @DeleteMapping("remove/{id}")
 public boolean delete(@PathVariable long id) {
	 System.out.print("invoked");
	 return ms.delete(id);
	 
 }
}

