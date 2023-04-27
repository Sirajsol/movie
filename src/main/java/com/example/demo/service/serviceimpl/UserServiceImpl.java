package com.example.demo.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
public class UserServiceImpl implements UserService {
private UserRepository ur;
	public UserServiceImpl(UserRepository rp) {
	super();
	this.ur = rp;
}
	@Override
	public Object finduser(String name, String password) {
		// TODO Auto-generated method stub
		return ur.findbynameandpassowrd(name, password);
	}
////	@Override
	public User findu(String name,String password) {
		// TODO Auto-generated method stub
		return ur.findby(name,password);
	}
//	@Override
//	public User findu(String name) {
//		// TODO Auto-generated method stub
//		return ur.findby(name);
//	}
}
