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
	
//	@RequestMapping("/home")
//	public String home(@RequestParam("name")String myName,HttpSession session)
//	{
//		
//		
//		System.out.println("Hi" + myName);
//
//		session.setAttribute("name", myName);
//		
//		return "home"; // In order to display jsp page , as spring boot doesn't support jsp we need to add one dependencies i.e tomcat Jasper(of the same version of the embeded tomcat. 
//	
//	}

	
	// instead of passing data (session.setAttribute("name", myName);)  and view name (return "home";) like this in above code with the help of session object , we can use ModelAndView object 
	
	
	@RequestMapping("home")
	public ModelAndView home(@RequestParam("name")String myName)
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("name",myName);
		mv.setViewName("home");
		return mv;
	}
	
}