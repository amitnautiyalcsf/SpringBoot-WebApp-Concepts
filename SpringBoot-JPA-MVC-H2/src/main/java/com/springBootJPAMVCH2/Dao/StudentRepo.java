package com.springBootJPAMVCH2.Dao;

import org.springframework.data.repository.CrudRepository;

import com.springBootJPAMVCH2.model.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> 
{
	
	

}
