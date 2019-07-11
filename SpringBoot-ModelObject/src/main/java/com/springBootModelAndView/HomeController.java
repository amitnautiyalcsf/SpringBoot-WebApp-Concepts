package com.springBootModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	
	@RequestMapping("home")
	public ModelAndView home(Student stud)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj",stud);
		mv.setViewName("home");
		return mv;
	}
	
}