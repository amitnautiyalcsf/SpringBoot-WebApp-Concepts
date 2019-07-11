package com.springBootJPAMVCH2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springBootJPAMVCH2.Dao.StudentRepo;
import com.springBootJPAMVCH2.model.Student;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepo repo;

	@RequestMapping("/")
	public String home() {

		return "home";
	}

	
	
	@RequestMapping("/addStud")
	public String addStudent(Student stud)
	{
		repo.save(stud);
		
		return "home";

	}

	@RequestMapping("/getStud")
	public ModelAndView getStudent(@RequestParam int sid)
	{
		ModelAndView mv= new ModelAndView("show");
		Student student= repo.findById(sid).orElse(new Student());
		mv.addObject(student);
		
		
		System.out.println(mv.toString());
		return mv ;

	}
	
	
	
	@RequestMapping("/getStud1")
	public ModelAndView getStudentbyTech(@RequestParam int sid)
	{
		ModelAndView mv= new ModelAndView("show");
	
		Student student=repo.findById(sid).orElse(new Student());
		
		// Try all statement one by one and see the output in the console.
		
		 System.out.println(repo.findByTech("Java"));
		 System.out.println(repo.findBySidGreaterThan(102));
		 System.out.println(repo.findBySidLessThan(104));
		
		 System.out.println(repo.findByTechSorted("Java"));
		 mv.addObject(student);
		 return mv ;

	}
	
	
	
}
