package com.MRBSBooking.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.MRBSBooking.Bean.LoginBean;

@Controller
@RequestMapping("/control")
@SessionAttributes("login")
public class LoginController {

	@Autowired
	Environment environment;
	
	//This is the main Controller that directs the Login Validation.
@RequestMapping(method = RequestMethod.GET)
public ModelAndView logincontroller()
{
ModelAndView mv=new ModelAndView(Messages.getString("LoginController.0")); //$NON-NLS-1$
LoginBean loginbean=new LoginBean();
mv.addObject(loginbean);
return mv;
}

//This method is called for Validation after the details have been entered.
@RequestMapping(method = RequestMethod.POST)
public String logincontrol(LoginBean loginbean,HttpSession session)
{
	String port = environment.getProperty(Messages.getString("LoginController.1")); //$NON-NLS-1$
session.setAttribute(Messages.getString("LoginController.2"), loginbean.getUsername()); //$NON-NLS-1$
String url=Messages.getString("LoginController.3")+port+Messages.getString("LoginController.4"); //$NON-NLS-1$ //$NON-NLS-2$
RestTemplate rt=new RestTemplate();
String status=rt.postForObject(url, loginbean, String.class);

if(status.equals(Messages.getString("LoginController.5"))) //$NON-NLS-1$
	return Messages.getString("LoginController.6"); //$NON-NLS-1$
if(status.equals(Messages.getString("LoginController.7"))) //$NON-NLS-1$
	return Messages.getString("LoginController.8"); //$NON-NLS-1$
else
	return Messages.getString("LoginController.9"); //$NON-NLS-1$
	
}
}
