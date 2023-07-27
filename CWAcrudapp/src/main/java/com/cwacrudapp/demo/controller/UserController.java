package com.cwacrudapp.demo.controller;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.websocket.Session;

import com.cwacrudapp.demo.exception.UserNotFoundException;
import com.cwacrudapp.demo.model.AuthRequest;
import com.cwacrudapp.demo.model.User;
import com.cwacrudapp.demo.repository.UserRepository;
import com.cwacrudapp.demo.service.JwtService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.cwacrudapp.demo.model.User;
//import com.cwacrudapp.demo.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtService jwtService;
	
	   @Autowired
	    private AuthenticationManager authenticationManager;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}
	
	@GetMapping("/users")
	List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("user/{id}")
	User getUserById(@PathVariable Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser,@PathVariable Long id) {
		return userRepository.findById(id).map(user->{
			user.setUsername(newUser.getUsername());
			user.setName(newUser.getName());
//			user.setEmail(newUser.getEmail());
            return userRepository.save(user);
        }).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	@PutMapping("/user/update/{id}")
	User updateuserApi(@RequestBody User newuser,@PathVariable Long id) {
		
		return userRepository.findById(id).map(user->{ 
			user.setUsername(newuser.getUsername());
			user.setName(newuser.getName());
			
			return userRepository.save(user);
			}).orElseThrow(() -> new UserNotFoundException(id));
	
	}
	

	@DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }
	
//	@PostMapping("/authenticate")
//	public String authenToken(@RequestBody AuthRequest authrequest) {
//		User user = userRepository.findByUsername(authrequest.getUsername());
//		if (user != null) {
//			
//			if (user.getName() == authrequest.getPassword()) {
//				return jwtService.generateToken(authrequest.getUsername());
//			}
//		}
//		else {
//			return "Not found";
//		}
////		return jwtService.generateToken(authrequest.getUsername());
//		
//	}
	
	@PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }


    }
	
	
	
}
