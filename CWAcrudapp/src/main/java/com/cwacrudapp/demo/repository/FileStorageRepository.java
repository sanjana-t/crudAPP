package com.cwacrudapp.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cwacrudapp.demo.model.FileStorage;

public interface FileStorageRepository extends JpaRepository<FileStorage,Long>{

	Optional<FileStorage> findByName(String name);
}
