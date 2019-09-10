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

import org.springframework.core.ParameterizedTypeReference;
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
	LoginBean loginbean=new LoginBean();
	MeetingRequest meetingrequest=new MeetingRequest();
	MeetingRoom meetingroom=new MeetingRoom();
	Resource resource=new Resource();
	
	//This method is called when the Admin clicks on the Add User option in the JSP.
@RequestMapping( value="/add",method = RequestMethod.POST)
public String adduser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	loginbean.setUsername(request.getParameter("uname"));
	loginbean.setPassword(request.getParameter("pwd"));
	loginbean.setRole("user");
	String url="http://localhost:8082/adminrest/adduser";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, loginbean, String.class);
	if(status.equals("success"))
		return "redirect:AdminFunctionalities.jsp";
	else
		return "redirect:Error.jsp";
}
	
	//This method is called when the Admin clicks on the Delete User option in the JSP.
@RequestMapping( value="/delete",method = RequestMethod.POST)
public String deleteuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	loginbean.setUsername(request.getParameter("uname"));
	String url="http://localhost:8082/adminrest/deleteuser";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, loginbean, String.class);
	if(status.equals("success"))
		return "redirect:AdminFunctionalities.jsp";
	else
		return "redirect:Error.jsp";
}

	//This method is called when the Admin clicks on the Add Meeting Room option in the JSP.
@RequestMapping( value="/addmr",method = RequestMethod.POST)
public String addmr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	meetingroom.setMeetingroomname(request.getParameter("mrname"));
	meetingroom.setMeetingroomnumber(request.getParameter("mrno"));
	String url="http://localhost:8082/adminrest/addmr";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingroom, String.class);
	if(status.equals("success"))
		return "redirect:AdminFunctionalities.jsp";
	else
		return "redirect:Error.jsp";
}
	
	//This method is called when the Admin clicks on the Add Resource option in the JSP.
@RequestMapping( value="/addresource",method = RequestMethod.POST)
public String addresource(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	resource.setResourcename(request.getParameter("resourcename"));
	resource.setResourcenumber(request.getParameter("resourceno"));
	String url="http://localhost:8082/adminrest/addresource";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, resource, String.class);
	if(status.equals("success"))
		return "redirect:AdminFunctionalities.jsp";
	else
		return "redirect:Error.jsp";
}

	//This method is called when the Admin clicks on the View All Bookings option in the JSP.
@RequestMapping(value="/view",method = RequestMethod.GET)
public ModelAndView viewallRequests(HttpServletRequest request, HttpServletResponse response) {
RestTemplate resttemplate = new RestTemplate();
ModelAndView modelandview = new ModelAndView();
ResponseEntity<List<MeetingRequest>> responseEntity = resttemplate.exchange("http://localhost:8082/adminrest/viewrequests",
HttpMethod.GET, null, new ParameterizedTypeReference<List<MeetingRequest>>() {
});
modelandview.addObject("list", responseEntity.getBody());
request.setAttribute("list", responseEntity.getBody());
modelandview.setViewName("ViewBookings.jsp");
return modelandview;
}

	//This method is called when the Admin clicks on the Accept or Reject option in the JSP.
@RequestMapping(value="/AcceptReject",method = RequestMethod.GET)
public ModelAndView viewRequests(HttpServletRequest request, HttpServletResponse response) {
RestTemplate resttemplate = new RestTemplate();
ModelAndView modelandview = new ModelAndView();
ResponseEntity<List<MeetingRequest>> responseEntity = resttemplate.exchange("http://localhost:8082/adminrest/getrequests",
HttpMethod.GET, null, new ParameterizedTypeReference<List<MeetingRequest>>() {
});
modelandview.addObject("list", responseEntity.getBody());
request.setAttribute("list", responseEntity.getBody());
modelandview.setViewName("AcceptorReject.jsp");
return modelandview;
}

	//This method is called when the Admin clicks on the Accept Request option in the JSP.
@RequestMapping( value="/acceptrequest",method = RequestMethod.POST)
public String acceptrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	meetingrequest.setId(Integer.parseInt(request.getParameter("id")));
	String url="http://localhost:8082/adminrest/acceptrequest";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingrequest, String.class);
	if(status.equals("accepted"))
		return "redirect:AdminFunctionalities.jsp";
	else
		return "redirect:Error.jsp";
}

	//This method is called when the Admin clicks on the Reject Request option in the JSP.
@RequestMapping( value="/rejectrequest",method = RequestMethod.POST)
public String rejectrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	meetingrequest.setId(Integer.parseInt(request.getParameter("id")));
	String url="http://localhost:8082/adminrest/rejectrequest";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingrequest, String.class);
	if(status.equals("rejected"))
		return "redirect:AdminFunctionalities.jsp";
	else
		return "redirect:Error.jsp";
}

	//This method is called when the Admin wants to select a Resource for its usage in the JSP.
@RequestMapping(value="/resourceselect",method = RequestMethod.GET)
public ModelAndView resources(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException 
{
RestTemplate resttemplate = new RestTemplate();
ResponseEntity<ArrayList<String>> responseEntity1 = resttemplate.exchange("http://localhost:8082/adminrest/getresource",
HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ModelAndView mv=new ModelAndView("MostUsedResource.jsp");
mv.addObject("resources", responseEntity1.getBody());
return mv;
}

	//This method is called when the Admin clicks on the Most Used Resource option in the JSP.
@RequestMapping(value="resourceused",method = RequestMethod.POST)
public String requestmeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	meetingrequest.setResource(request.getParameter("resource"));
	String url="http://localhost:8082/adminrest/resourceused";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url,meetingrequest, String.class);
	if(status!=null)
	{
		request.setAttribute("status", status);
		RequestDispatcher requestdispatcher=request.getRequestDispatcher("ResourceUsage.jsp");
		requestdispatcher.forward(request, response);
		return status;
	}
	else
		return "redirect:Error.jsp";
}

	//This method is called when the Admin wants to select a Meeting Room for its Usage in the JSP.
@RequestMapping(value="/meetingroomselect",method = RequestMethod.GET)
public ModelAndView meetingrooms(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException 
{
RestTemplate resttemplate = new RestTemplate();
ResponseEntity<ArrayList<String>> responseEntity1 = resttemplate.exchange("http://localhost:8082/adminrest/getmeetingroom",
HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ModelAndView mv=new ModelAndView("MostUsedMeetingRoom.jsp");
mv.addObject("meetingrooms", responseEntity1.getBody());
return mv;
}

	//This method is called when the Admin clicks on the Most Used Meeting Room option in the JSP.
@RequestMapping(value="mostusedmeetingroom",method = RequestMethod.POST)
public String mostusedmeetingroom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	meetingrequest.setMrname(request.getParameter("mrname"));
	String url="http://localhost:8082/adminrest/mostusedmeetingroom";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url,meetingrequest, String.class);
	if(status!=null)
	{
		request.setAttribute("status", status);
		RequestDispatcher requestdispatcher=request.getRequestDispatcher("MeetingRoomUsage.jsp");
		requestdispatcher.forward(request, response);
		return status;
	}
	else
		return "redirect:Error.jsp";
}
}
