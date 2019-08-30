package com.example.demo.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Bean.LoginBean;

@Controller
@RequestMapping("/control")
@SessionAttributes("login")
public class LoginController {

	//This is the main Controller that directs the Login Validation.
@RequestMapping(method = RequestMethod.GET)
public ModelAndView logincontroller()
{
ModelAndView mv=new ModelAndView("Login.jsp");
LoginBean loginbean=new LoginBean();
mv.addObject(loginbean);
System.out.println(mv);
return mv;
}

//This method is called for Validation after the details have been entered.
@RequestMapping(method = RequestMethod.POST)
public String logincontrol(LoginBean loginbean,HttpSession session)
{
System.out.println(loginbean);
session.setAttribute("username", loginbean.getUsername());
String url="http://localhost:8082/myresource/insert";
RestTemplate rt=new RestTemplate();
String status=rt.postForObject(url, loginbean, String.class);
System.out.println(status);
if(status.equals("admin"))
	return "redirect:AdminFunctionalities.jsp";
if(status.equals("user"))
	return "redirect:UserFunctionalities.jsp";
else
	return "redirect:Error.jsp";
	
}
}
