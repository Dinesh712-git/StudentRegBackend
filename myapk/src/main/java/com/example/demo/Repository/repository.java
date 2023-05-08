package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.student;

public interface repository extends JpaRepository<student,Long>{
	

}
