package com.springBootWithREST.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springBootWithREST.Dao.StudentRepo;
import com.springBootWithREST.model.Student;

//@Controller 
@RestController // instead of using controller use RestController.
public class StudentController {
	
	@Autowired
	StudentRepo repo;

	@RequestMapping("/")
	public String home() {

		return "home";
	}

	
	
	
	
	
	@RequestMapping("/students/102")
//	@ResponseBody // here we are telling the dispatcher servlet to print the data and not look for the view. // instead of using response Body everytime we can use Annotation RestController.
	public String getStudent()
	{
		
		return repo.findById(102).toString();
		
		
	}
	
	@RequestMapping("/students/{sid}")
// @ResponseBody // here we are telling the dispatcher servlet to print the data and not look for the view.
	public Optional<Student> getStudents(@PathVariable int sid)
	{
		
		return repo.findById(sid);
		
		
	}
	
	
	
	
	
	@GetMapping(path = "/students",produces = {"application/xml"})// here server only produces the data in the form of xml only and in order to achive that i added one jackson data format xml dependency 
	  //@ResponseBody // here we are telling the dispatcher servlet to print the data and not look for the view.
		public List<Student> getStudents()
		{
			
			return repo.findAll();
			
			
		}
		
		@PostMapping(path= "/students", consumes = {"application/json"}) // here i fixes that the server is only accepting the json data from client not xml.
	    public Student addStudent(@RequestBody Student student)
		{
			repo.save(student);
			return student;
			
		}
	
	@DeleteMapping("/students/{sid}")
	public String deleteStudent( @PathVariable int sid)
	{
		Student s= repo.getOne(sid);
		repo.delete(s);
		return "Deleted Successfully";
		
	}
	
	
	@PutMapping(path= "/students", consumes = {"application/json"}) // here i fixes that the server is only accepting the json data from client not xml.
    public Student saveOrUpdateStudent(@RequestBody Student student)
	{
		repo.save(student);
		return student;
		
	}
	
	
	
	
	
	
	
	
}
