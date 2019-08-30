package com.example.demo.Controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Bean.MeetingRequest;

//This is the main Controller that directs the UserFunctionalities.
@Controller
public class UserController {
	MeetingRequest meetingrequest=new MeetingRequest();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	LocalDateTime now = LocalDateTime.now();
	DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("HH:mm:ss");
	LocalDateTime nowtime = LocalDateTime.now();

//This method is called when the User wants to select from Resources and Meeting Rooms.
@RequestMapping(value="meetingrequest",method = RequestMethod.POST)
public ModelAndView meetingRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
String variable=request.getParameter("operation");
if(variable.equals("request"))
{
RestTemplate rest = new RestTemplate();
ResponseEntity<ArrayList<String>> responseEntity = rest.exchange("http://localhost:8082/userfunctionalities/getmeetingroom", HttpMethod.GET,
null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ResponseEntity<ArrayList<String>> responseEntity1 = rest.exchange("http://localhost:8082/userfunctionalities/getresource",
HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<String>>() {
});
ModelAndView mv=new ModelAndView("RequestMR.jsp");
mv.addObject("meetingrooms", responseEntity.getBody());
mv.addObject("resources", responseEntity1.getBody());
return mv;
}
return null;
}

//This Method is called when the User clicks on the Request Meeting Room option in JSP.
@RequestMapping(value="requestmr",method = RequestMethod.POST)
public String requestmeeting(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	HttpSession session=request.getSession();
	MeetingRequest meetingrequest=new MeetingRequest();
	meetingrequest.setMrname(request.getParameter("mrname"));
	meetingrequest.setStartdate(request.getParameter("startdate"));
	meetingrequest.setEnddate(request.getParameter("enddate"));
	meetingrequest.setStarttime(request.getParameter("starttime"));
	meetingrequest.setEndtime(request.getParameter("endtime"));
	meetingrequest.setResource(request.getParameter("resource"));
	meetingrequest.setStatus("new");
	meetingrequest.setDatestamp((dtf.format(now)));
	meetingrequest.setTimestamp((dtf1.format(nowtime)));
	meetingrequest.setUser((String) session.getAttribute("username"));
	String url="http://localhost:8082/userfunctionalities/requestmeetingroom";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url,meetingrequest, String.class);
	if(status.equals("REQUESTED"))
	{
		return "redirect:UserFunctionalities.jsp";
	}
	else
		return "redirect:Error.jsp";
}

//This method is called when the User clicks on Cancel Request to view his requests in the JSP.
@RequestMapping(value="/cancelview",method = RequestMethod.GET)
public ModelAndView viewRequests(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session=request.getSession();
	RestTemplate resttemplate = new RestTemplate();
	ModelAndView modelandview = new ModelAndView();
	String user=(String) session.getAttribute("username");
	ResponseEntity<ArrayList<MeetingRequest>> responseEntity = resttemplate.exchange("http://localhost:8082/userfunctionalities/cancelview/"+user,
			HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<MeetingRequest>>() {
	});
	modelandview.addObject("list", responseEntity.getBody());
	request.setAttribute("list", responseEntity.getBody());
	modelandview.setViewName("CancelRequest.jsp");
	return modelandview;
}

//This method is called when the User clicks on the Cancel Request in the JSp.
@RequestMapping( value="/cancelrequest",method = RequestMethod.POST)
public String cancelrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	meetingrequest.setId(Integer.parseInt(request.getParameter("id")));
	String url="http://localhost:8082/userfunctionalities/cancelrequest";
	RestTemplate resttemplate=new RestTemplate();
	String status=resttemplate.postForObject(url, meetingrequest, String.class);
	if(status.equals("cancelled"))
		return "redirect:UserFunctionalities.jsp";
	else
		return "redirect:Error.jsp";
}
}