package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
@CrossOrigin("*")
@RestController
@RequestMapping("user")
public class UserController {
private UserService us;
//@PostMapping("{name}/{pass}")
//public Object getit(@PathVariable String name,@PathVariable String pass) {
//	
//	return us.finduser(name, pass);
//}

@PostMapping("{name}/{pass}")
public User gettit(@PathVariable String name,@PathVariable String pass) {
	
	return us.findu(name,pass);
}
//if you want to post a request body:
//@PostMapping("sv")
//public User gettit(@RequestBody String name) {
//	System.out.println("select * from move.user where user.username= "+name.substring(0, name.length()-1));
//	return us.findu(name.substring(0, name.length()-1));
//}

//@PostMapping("/us")
//public Object getit(@RequestParam("u") String[]s) {
//	
//	return us.finduser(s[0], s[1]);
//}
public UserController(UserService us) {
	super();
	this.us = us;
}

}
