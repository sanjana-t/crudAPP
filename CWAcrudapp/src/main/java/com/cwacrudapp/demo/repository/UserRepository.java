package com.cwacrudapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

//import com.course5i.questionnairerepository.entity.UserDetails;
import com.cwacrudapp.demo.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

	
	User findByUsername(String name);
	

	
}
