package com.MRBSBooking.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MRBSBooking.Bean.LoginBean;
import com.MRBSBooking.Bean.MeetingRequest;
import com.MRBSBooking.Bean.MeetingRoom;
import com.MRBSBooking.Bean.Resource;
import com.MRBSBooking.Dao.AdminDao;
import com.MRBSBooking.Repository.MeetingRequestInterface;

@RestController
@RequestMapping("/adminrest")
public class AdminRestController {

	@Autowired
	AdminDao admindao;
	
	@Autowired
	MeetingRequestInterface meetingrequestinterface;
	
	//This method is called by the AdminController, This method goes to [adduser] method in AdminDao.
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String add(@RequestBody LoginBean login) {
	String status=admindao.adduser(login);
	return status;
	}
	
	//This method is called by the AdminController, This method goes to [deleteuser] method in AdminDao.
	@RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
	public String delete(@RequestBody LoginBean login) {
	String status=admindao.deleteuser(login);
	return status;
	}
	
	//This method is called by the AdminController, This method goes to [addmr] method in AdminDao.
	@RequestMapping(value = "/addmr", method = RequestMethod.POST)
	public String addmr(@RequestBody MeetingRoom meetingroom) {
	String status=admindao.addmr(meetingroom);
	return status;
	}
	
	//This method is called by the AdminController, This method goes to [addresource] method in AdminDao.
	@RequestMapping(value = "/addresource", method = RequestMethod.POST)
	public String addresource(@RequestBody Resource resource) {
	String status=admindao.addresource(resource);
	return status;
	}
	
	//This method is called by the AdminController, This method goes to [viewrequests] method in AdminDao.
	@RequestMapping(value = "/viewrequests", method = RequestMethod.GET)
	public ArrayList<MeetingRequest> viewrequests()
	{
	return admindao.viewrequests();
	}
	
	//This method is called by the AdminController, This method goes to [acceptorreject] method in AdminDao.
	@RequestMapping(value = "/getrequests", method = RequestMethod.GET)
	public ArrayList<MeetingRequest> getrequests()
	{
	return admindao.acceptorreject();
	}
	
	//This method is called by the AdminController, This method goes to [acceptrequest] method in AdminDao.
	@RequestMapping(value = "/acceptrequest", method = RequestMethod.POST)
	public String acceptrequest(@RequestBody MeetingRequest meetingrequest) {
	String status=admindao.acceptrequest(meetingrequest);
	return status;
	}
	
	//This method is called by the AdminController, This method goes to [rejectrequest] method in AdminDao.
	@RequestMapping(value = "/rejectrequest", method = RequestMethod.POST)
	public String rejectrequest(@RequestBody MeetingRequest meetingrequest) {
	String status=admindao.rejectrequest(meetingrequest);
	return status;
	}
	
	//This method is called by the AdminController, This method goes to [getResource] method in AdminDao.
	@RequestMapping(value = "/getresource", method = RequestMethod.GET)
	public ArrayList<String> getresource()
	{
	return admindao.getResource();
	}
	
	//This method is called by the AdminController, This method goes to [resourceused] method in AdminDao.
	@RequestMapping(value = "/resourceused", method = RequestMethod.POST)
	public String resourceused(@RequestBody MeetingRequest meetingrequest) {
	String status=admindao.resourceused(meetingrequest);
	return status;
	}
	
	//This method is called by the AdminController, This method goes to [getMeetingRoom] method in AdminDao.
	@RequestMapping(value = "/getmeetingroom", method = RequestMethod.GET)
	public ArrayList<String> getmeetingroom()
	{
	return admindao.getMeetingRoom();
	}
	
	//This method is called by the AdminController, This method goes to [meetingroomused] method in AdminDao.
	@RequestMapping(value = "/mostusedmeetingroom", method = RequestMethod.POST)
	public String mostusedmeetingroom(@RequestBody MeetingRequest meetingrequest) {
	String status=admindao.meetingroomused(meetingrequest);
	return status;
	}
}
