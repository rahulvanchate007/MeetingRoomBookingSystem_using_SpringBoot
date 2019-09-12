package com.MRBSBooking.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.MRBSBooking.Bean.MeetingRequest;

//This is the main Controller that directs the UserFunctionalities.
@Controller
public class UserController {
	
	@Autowired
	Environment environment;
	
	MeetingRequest meetingrequest=new MeetingRequest();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern(Messages.getString("UserController.0")); //$NON-NLS-1$
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(Messages.getString("UserController.1")); //$NON-NLS-1$
	LocalDateTime nowtime = LocalDateTime.now();

//This method is called when the User wants to select from Resources and Meeting Rooms.
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
@RequestMapping(value="meetingrequest",method = RequestMethod.POST)
public ModelAndView meetingRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("UserController.2")); //$NON-NLS-1$
String variable=request.getParameter(Messages.getString("UserController.3")); //$NON-NLS-1$
if(variable.equals(Messages.getString("UserController.4"))) //$NON-NLS-1$
{
RestTemplate rest = new RestTemplate();
ResponseEntity<ArrayList<String>> responseEntity = rest.exchange(Messages.getString("UserController.5")+port+Messages.getString("UserController.6"), HttpMethod.GET, //$NON-NLS-1$ //$NON-NLS-2$
null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ResponseEntity<ArrayList<String>> responseEntity1 = rest.exchange(Messages.getString("UserController.7")+port+Messages.getString("UserController.8"), //$NON-NLS-1$ //$NON-NLS-2$
HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ModelAndView mv=new ModelAndView(Messages.getString("UserController.9")); //$NON-NLS-1$
mv.addObject(Messages.getString("UserController.10"), responseEntity.getBody()); //$NON-NLS-1$
mv.addObject(Messages.getString("UserController.11"), responseEntity1.getBody()); //$NON-NLS-1$
return mv;
}
return null;
}

/** 
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 */
//This Method is called when the User clicks on the Request Meeting Room option in JSP.
@RequestMapping(value="requestmr",method = RequestMethod.POST)
public String requestmeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("UserController.12")); //$NON-NLS-1$
	HttpSession session=request.getSession();
	MeetingRequest meetingrequest=new MeetingRequest();
	meetingrequest.setMrname(request.getParameter(Messages.getString("UserController.13"))); //$NON-NLS-1$
	meetingrequest.setStartdate(request.getParameter(Messages.getString("UserController.14"))); //$NON-NLS-1$
	meetingrequest.setEnddate(request.getParameter(Messages.getString("UserController.15"))); //$NON-NLS-1$
	meetingrequest.setStarttime(request.getParameter(Messages.getString("UserController.16"))); //$NON-NLS-1$
	meetingrequest.setEndtime(request.getParameter(Messages.getString("UserController.17"))); //$NON-NLS-1$
	meetingrequest.setResource(request.getParameter(Messages.getString("UserController.18"))); //$NON-NLS-1$
	meetingrequest.setStatus(Messages.getString("UserController.19")); //$NON-NLS-1$
	meetingrequest.setDatestamp((dtf.format(now)));
	meetingrequest.setTimestamp((dtf1.format(nowtime)));
	meetingrequest.setUser((String) session.getAttribute(Messages.getString("UserController.20"))); //$NON-NLS-1$
	String url=Messages.getString("UserController.21")+port+Messages.getString("UserController.22"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url,meetingrequest, String.class);
	if(status.equals(Messages.getString("UserController.23"))) //$NON-NLS-1$
	{
		return Messages.getString("UserController.24"); //$NON-NLS-1$
	}
	else
		return Messages.getString("UserController.25"); //$NON-NLS-1$
}

//This method is called when the User clicks on Cancel Request to view his requests in the JSP.
@RequestMapping(value="/cancelview",method = RequestMethod.GET)
public ModelAndView viewRequests(HttpServletRequest request, HttpServletResponse response) {
	String port = environment.getProperty(Messages.getString("UserController.26")); //$NON-NLS-1$
	HttpSession session=request.getSession();
	RestTemplate resttemplate = new RestTemplate();
	ModelAndView modelandview = new ModelAndView();
	String user=(String) session.getAttribute(Messages.getString("UserController.27")); //$NON-NLS-1$
	ResponseEntity<ArrayList<MeetingRequest>> responseEntity = resttemplate.exchange(Messages.getString("UserController.28")+port+Messages.getString("UserController.29")+user, //$NON-NLS-1$ //$NON-NLS-2$
			HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<MeetingRequest>>() {
	});
	modelandview.addObject(Messages.getString("UserController.30"), responseEntity.getBody()); //$NON-NLS-1$
	request.setAttribute(Messages.getString("UserController.31"), responseEntity.getBody()); //$NON-NLS-1$
	modelandview.setViewName(Messages.getString("UserController.32")); //$NON-NLS-1$
	return modelandview;
}

//This method is called when the User clicks on the Cancel Request in the JSp.
@RequestMapping( value="/cancelrequest",method = RequestMethod.POST)
public String cancelrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	String port = environment.getProperty(Messages.getString("UserController.33")); //$NON-NLS-1$
	meetingrequest.setId(Integer.parseInt(request.getParameter(Messages.getString("UserController.34")))); //$NON-NLS-1$
	String url=Messages.getString("UserController.35")+port+Messages.getString("UserController.36"); //$NON-NLS-1$ //$NON-NLS-2$
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingrequest, String.class);
	if(status.equals(Messages.getString("UserController.37"))) //$NON-NLS-1$
		return Messages.getString("UserController.38"); //$NON-NLS-1$
	else
		return Messages.getString("UserController.39"); //$NON-NLS-1$
}
}