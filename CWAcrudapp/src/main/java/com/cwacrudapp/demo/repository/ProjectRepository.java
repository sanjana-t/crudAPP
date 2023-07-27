package com.cwacrudapp.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwacrudapp.demo.model.ProjectTable;

public interface ProjectRepository extends JpaRepository<ProjectTable,Long> {

	List<ProjectTable> findAll();
}
