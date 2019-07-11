package com.SpringBootAcceptingClientData;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	
	@RequestMapping("/home")
	public String home(HttpServletRequest req, HttpServletResponse res)
	{
		
		HttpSession session=req.getSession();
		
		String name= req.getParameter("name");
		
		System.out.println("Hi" + name);

		session.setAttribute("name", name);
		
		return "home"; // In order to display jsp page , as spring boot doesn't support jsp we need to add one dependencies i.e tomcat Jasper(of the same version of the embeded tomcat. 
	
	}

}