package com.MRBSBooking.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.ws.rs.core.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.MRBSBooking.Bean.LoginBean;
import com.MRBSBooking.Bean.MeetingRequest;
import com.MRBSBooking.Bean.MeetingRoom;
import com.MRBSBooking.Bean.Resource;

//This is the Main Controller that directs the Admin Functionalities
@Controller
public class AdminController {
	
	@Autowired
	Environment environment;
	LoginBean loginbean=new LoginBean();
	MeetingRequest meetingrequest=new MeetingRequest();
	MeetingRoom meetingroom=new MeetingRoom();
	Resource resource=new Resource();
	
	//This method is called when the Admin clicks on the Add User option in the JSP.
@RequestMapping( value="/add",method = RequestMethod.POST)
public String adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.0")); //$NON-NLS-1$
	loginbean.setUsername(request.getParameter(Messages.getString("AdminController.1"))); //$NON-NLS-1$
	loginbean.setPassword(request.getParameter(Messages.getString("AdminController.2"))); //$NON-NLS-1$
	loginbean.setRole(Messages.getString("AdminController.3")); //$NON-NLS-1$
	String url=Messages.getString("AdminController.4")+port+Messages.getString("AdminController.5"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, loginbean, String.class);
	if(status.equals(Messages.getString("AdminController.6"))) //$NON-NLS-1$
		return Messages.getString("AdminController.7"); //$NON-NLS-1$
	else
		return Messages.getString("AdminController.8"); //$NON-NLS-1$
}
	
	//This method is called when the Admin clicks on the Delete User option in the JSP.
@RequestMapping( value="/delete",method = RequestMethod.POST)
public String deleteuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.9")); //$NON-NLS-1$
	loginbean.setUsername(request.getParameter(Messages.getString("AdminController.10"))); //$NON-NLS-1$
	String url=Messages.getString("AdminController.11")+port+Messages.getString("AdminController.12"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, loginbean, String.class);
	if(status.equals(Messages.getString("AdminController.13"))) //$NON-NLS-1$
		return Messages.getString("AdminController.14"); //$NON-NLS-1$
	else
		return Messages.getString("AdminController.15"); //$NON-NLS-1$
}

	//This method is called when the Admin clicks on the Add Meeting Room option in the JSP.
@RequestMapping( value="/addmr",method = RequestMethod.POST)
public String addmr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.16")); //$NON-NLS-1$
	meetingroom.setMeetingroomname(request.getParameter(Messages.getString("AdminController.17"))); //$NON-NLS-1$
	meetingroom.setMeetingroomnumber(request.getParameter(Messages.getString("AdminController.18"))); //$NON-NLS-1$
	String url=Messages.getString("AdminController.19")+port+Messages.getString("AdminController.20"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingroom, String.class);
	if(status.equals(Messages.getString("AdminController.21"))) //$NON-NLS-1$
		return Messages.getString("AdminController.22"); //$NON-NLS-1$
	else
		return Messages.getString("AdminController.23"); //$NON-NLS-1$
}
	
	//This method is called when the Admin clicks on the Add Resource option in the JSP.
@RequestMapping( value="/addresource",method = RequestMethod.POST)
public String addresource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.24")); //$NON-NLS-1$
	resource.setResourcename(request.getParameter(Messages.getString("AdminController.25"))); //$NON-NLS-1$
	resource.setResourcenumber(request.getParameter(Messages.getString("AdminController.26"))); //$NON-NLS-1$
	String url=Messages.getString("AdminController.27")+port+Messages.getString("AdminController.28"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, resource, String.class);
	if(status.equals(Messages.getString("AdminController.29"))) //$NON-NLS-1$
		return Messages.getString("AdminController.30"); //$NON-NLS-1$
	else
		return Messages.getString("AdminController.31"); //$NON-NLS-1$
}

	//This method is called when the Admin clicks on the View All Bookings option in the JSP.
@RequestMapping(value="/view",method = RequestMethod.GET)
public ModelAndView viewallRequests(HttpServletRequest request, HttpServletResponse response) {
	String port = environment.getProperty(Messages.getString("AdminController.32")); //$NON-NLS-1$
RestTemplate resttemplate = new RestTemplate();
ModelAndView modelandview = new ModelAndView();
ResponseEntity<List<MeetingRequest>> responseEntity = resttemplate.exchange(Messages.getString("AdminController.33")+port+Messages.getString("AdminController.34"), //$NON-NLS-1$ //$NON-NLS-2$
HttpMethod.GET, null, new ParameterizedTypeReference<List<MeetingRequest>>() {
});
modelandview.addObject(Messages.getString("AdminController.35"), responseEntity.getBody()); //$NON-NLS-1$
request.setAttribute(Messages.getString("AdminController.36"), responseEntity.getBody()); //$NON-NLS-1$
modelandview.setViewName(Messages.getString("AdminController.37")); //$NON-NLS-1$
return modelandview;
}

	//This method is called when the Admin clicks on the Accept or Reject option in the JSP.
@RequestMapping(value="/AcceptReject",method = RequestMethod.GET)
public ModelAndView viewRequests(HttpServletRequest request, HttpServletResponse response) {
	String port = environment.getProperty(Messages.getString("AdminController.38")); //$NON-NLS-1$
RestTemplate resttemplate = new RestTemplate();
ModelAndView modelandview = new ModelAndView();
ResponseEntity<List<MeetingRequest>> responseEntity = resttemplate.exchange(Messages.getString("AdminController.39")+port+Messages.getString("AdminController.40"), //$NON-NLS-1$ //$NON-NLS-2$
HttpMethod.GET, null, new ParameterizedTypeReference<List<MeetingRequest>>() {
});
modelandview.addObject(Messages.getString("AdminController.41"), responseEntity.getBody()); //$NON-NLS-1$
request.setAttribute(Messages.getString("AdminController.42"), responseEntity.getBody()); //$NON-NLS-1$
modelandview.setViewName(Messages.getString("AdminController.43")); //$NON-NLS-1$
return modelandview;
}

	//This method is called when the Admin clicks on the Accept Request option in the JSP.
@RequestMapping( value="/acceptrequest",method = RequestMethod.POST)
public String acceptrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.44")); //$NON-NLS-1$
	meetingrequest.setId(Integer.parseInt(request.getParameter(Messages.getString("AdminController.45")))); //$NON-NLS-1$
	String url=Messages.getString("AdminController.46")+port+Messages.getString("AdminController.47"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingrequest, String.class);
	if(status.equals(Messages.getString("AdminController.48"))) //$NON-NLS-1$
		return Messages.getString("AdminController.49"); //$NON-NLS-1$
	else
		return Messages.getString("AdminController.50"); //$NON-NLS-1$
}

	//This method is called when the Admin clicks on the Reject Request option in the JSP.
@RequestMapping( value="/rejectrequest",method = RequestMethod.POST)
public String rejectrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.51")); //$NON-NLS-1$
	meetingrequest.setId(Integer.parseInt(request.getParameter(Messages.getString("AdminController.52")))); //$NON-NLS-1$
	String url=Messages.getString("AdminController.53")+port+Messages.getString("AdminController.54"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingrequest, String.class);
	if(status.equals(Messages.getString("AdminController.55"))) //$NON-NLS-1$
		return Messages.getString("AdminController.56"); //$NON-NLS-1$
	else
		return Messages.getString("AdminController.57"); //$NON-NLS-1$
}

	//This method is called when the Admin wants to select a Resource for its usage in the JSP.
@RequestMapping(value="/resourceselect",method = RequestMethod.GET)
public ModelAndView resources(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.58")); //$NON-NLS-1$
RestTemplate resttemplate = new RestTemplate();
ResponseEntity<ArrayList<String>> responseEntity1 = resttemplate.exchange(Messages.getString("AdminController.59")+port+Messages.getString("AdminController.60"), //$NON-NLS-1$ //$NON-NLS-2$
HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ModelAndView mv=new ModelAndView(Messages.getString("AdminController.61")); //$NON-NLS-1$
mv.addObject(Messages.getString("AdminController.62"), responseEntity1.getBody()); //$NON-NLS-1$
return mv;
}

	//This method is called when the Admin clicks on the Most Used Resource option in the JSP.
@RequestMapping(value="resourceused",method = RequestMethod.POST)
public String requestmeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.63")); //$NON-NLS-1$
	meetingrequest.setResource(request.getParameter(Messages.getString("AdminController.64"))); //$NON-NLS-1$
	String url=Messages.getString("AdminController.65")+port+Messages.getString("AdminController.66"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url,meetingrequest, String.class);
	if(status!=null)
	{
		request.setAttribute(Messages.getString("AdminController.67"), status); //$NON-NLS-1$
		RequestDispatcher requestdispatcher=request.getRequestDispatcher(Messages.getString("AdminController.68")); //$NON-NLS-1$
		requestdispatcher.forward(request, response);
		return status;
	}
	else
		return Messages.getString("AdminController.69"); //$NON-NLS-1$
}

	//This method is called when the Admin wants to select a Meeting Room for its Usage in the JSP.
@RequestMapping(value="/meetingroomselect",method = RequestMethod.GET)
public ModelAndView meetingrooms(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.70")); //$NON-NLS-1$
RestTemplate resttemplate = new RestTemplate();
ResponseEntity<ArrayList<String>> responseEntity1 = resttemplate.exchange(Messages.getString("AdminController.71")+port+Messages.getString("AdminController.72"), //$NON-NLS-1$ //$NON-NLS-2$
HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ModelAndView mv=new ModelAndView(Messages.getString("AdminController.73")); //$NON-NLS-1$
mv.addObject(Messages.getString("AdminController.74"), responseEntity1.getBody()); //$NON-NLS-1$
return mv;
}

	//This method is called when the Admin clicks on the Most Used Meeting Room option in the JSP.
@RequestMapping(value="mostusedmeetingroom",method = RequestMethod.POST)
public String mostusedmeetingroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("AdminController.75")); //$NON-NLS-1$
	meetingrequest.setMrname(request.getParameter(Messages.getString("AdminController.76"))); //$NON-NLS-1$
	String url=Messages.getString("AdminController.77")+port+Messages.getString("AdminController.78"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url,meetingrequest, String.class);
	if(status!=null)
	{
		request.setAttribute(Messages.getString("AdminController.79"), status); //$NON-NLS-1$
		RequestDispatcher requestdispatcher=request.getRequestDispatcher(Messages.getString("AdminController.80")); //$NON-NLS-1$
		requestdispatcher.forward(request, response);
		return status;
	}
	else
		return Messages.getString("AdminController.81"); //$NON-NLS-1$
}
}
