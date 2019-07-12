package com.springBootWithREST.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springBootWithREST.model.Student;


@RepositoryRestResource(collectionResourceRel = "students", path="students")// just this annotation done a works for us we need not to create any controller now.. :) 
public interface StudentRepo extends JpaRepository<Student, Integer>
{
	
	

}
