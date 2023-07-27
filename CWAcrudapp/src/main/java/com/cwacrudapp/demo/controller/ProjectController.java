package com.cwacrudapp.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cwacrudapp.demo.model.ProjectTable;
import com.cwacrudapp.demo.model.User;
import com.cwacrudapp.demo.repository.ProjectRepository;
import com.cwacrudapp.demo.repository.UserRepository;

@RestController
//@CrossOrigin("http://localhost:3000")
public class ProjectController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private ProjectRepository projectRepository;
	
	@PostMapping("/addProject")
	ProjectTable addProject(@RequestBody ProjectTable project) {
		return projectRepository.save(project);
	}

	@GetMapping("/getProjects")
	List<ProjectTable> getProject() {
		return projectRepository.findAll();
	}

}
