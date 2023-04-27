package com.example.demo.service.serviceimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.MovieService;

import jakarta.persistence.EntityManager;

import com.example.demo.model.Actor;
import  com.example.demo.model.Movie;
import com.example.demo.repository.actorrepository;
import  com.example.demo.repository.movierepository;
import com.example.demo.repository.newmvreepo;
@Service
public class MovieServiceImpl implements MovieService {
	private movierepository mr;
	private actorrepository ar;
	private newmvreepo nmr;
	@Autowired EntityManager em;
	public MovieServiceImpl(movierepository mr,actorrepository ar,newmvreepo nmr) {
//		super();
		this.mr = mr;
		this.ar = ar;
		this.nmr = nmr;
	}

	@Override
//	public List<Movie> findAll() {
//		// TODO Auto-generated method stub
//		return mr.findAll( );
//	}
	public Page<Movie> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return mr.findAll(pageable );
	}
	@Override
	public Movie save(Movie m) {
		// TODO Auto-generated method stub
//return mr.save(m);
		return  mr.save(m);
	}

	
	public Movie findname( String nm) {
		// TODO Auto-generated method stub
		return mr.findByName(nm);
	}

	@Override
	public Movie assign(long mid, long aid) {
//	public Set<Actor> assign(long mid, long aid) {
		// TODO Auto-generated method stub
		Movie m=mr.findById(mid).get();
		Actor a=ar.findById(aid).get();
		Set<Actor> actrs=null;
		actrs=m.getActors();
		actrs.add(a);
		m.setActors(actrs);
//		return actrs;
		return mr.save(m);
	
		
	}

	@Override
	public Set<String> mNames() {
		
		return mr.mnames();
	}

	@Override
	public Set<String> getActorsMovie(long id) {
		// TODO Auto-generated method stub
		return mr.actorsformovie(id);
	}
	public Set<Object>allactors( long id){
		return mr.allactorsformovie(id);
	}

	
	public Set<Movie> namelike(String name) {
		// TODO Auto-generated method stub
		return mr.namelike(name);
	}
	public Movie movieById(long id) {
		// TODO Auto-generated method stub
		
		return mr.findById(id).get();
	}
	public Movie update(long id,Movie m ) {
		Movie mv =null;
		mv=mr.findById(id).get();
		
			mv.setName(m.getName());
			mv.setGener(m.getGener());
			mv.setRate(m.getRate());
			mv.setDescription(m.getDescription());
			mv.setYear(m.getYear());
			mv.setImgdata(m.getImgdata());
		
		return mr.save(mv);
	}

	@Override
	public String[] iallactors(long id) {
		// TODO Auto-generated method stub
		return mr.iallactorsformovie(id);
	}

	@Override
	public Set<Movie> moviesByYear(int year) {
		// TODO Auto-generated method stub
		return mr.movieByYear(year);
	}

	@Override
	public Set<Movie> moviesByGener(String gener) {
		// TODO Auto-generated method stub
		return mr.movieByGener(gener);
	}

	@Override
	public Set<Movie> moviesByRate(int rate) {
		// TODO Auto-generated method stub
		return mr.movieByRate(rate);
	}

	@Override
	public int[] Years() {
		// TODO Auto-generated method stub
		return mr.Years();
	}

	@Override
	public Set<Object> allactorstoadd() {
		// TODO Auto-generated method stub
		return mr.allactorstoadd();
	}

		public boolean delete( long id) {
			try {
			Class.forName("com.mysql.jdbc.Driver");
			       String unicode = "?useUnicode=yes&characterEncoding=UTF-8";
			      Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/move" + unicode, "root", "root");
		      Statement st = c.createStatement();
		      System.out.print("delete from move.actor_movie_table where movie_id="+id);
		      //System.out.print("  affected: "+st.executeUpdate("delete from move.movie where movie.id="+id));
		      if(st.executeUpdate("delete from move.actor_movie_table where movie_id="+id)>=0) {
		    	 if( st.executeUpdate("delete from move.movie where movie.id="+id)>0) {
		    		 System.out.print("haha deleted");
		    	 }
		      };

			return true;
	 }
		      catch(Exception e) {
		    	  System.out.println("error during delete");
		    	  return false;
		      }
		// }
	}

		@Override
		public List<Movie> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

//	@Override
//	public int delete(long id) {
//		// TODO Auto-generated method stub
//		mr.delete(id);
//		return  1;
//	}
}
