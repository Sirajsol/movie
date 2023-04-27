package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query(value="select * from move.user where user.username=?1 and user.password=?2",nativeQuery = true)
	public Object findbynameandpassowrd(String name,String passwd);
//	@Query("From User where username=?1")
	
	@Query(value="select * from move.user where user.username=?1 and user.password=?2",nativeQuery = true)
	public User findby(String name,String password );
//	@Query(value="select * from move.user where user.username=?1",nativeQuery = true)
//	public User findby(String name);


}
