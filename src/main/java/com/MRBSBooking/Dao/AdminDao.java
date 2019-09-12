package com.MRBSBooking.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.MRBSBooking.Bean.LoginBean;
import com.MRBSBooking.Bean.MeetingRequest;
import com.MRBSBooking.Bean.MeetingRoom;
import com.MRBSBooking.Bean.Resource;
import com.MRBSBooking.Repository.LoginInterface;
import com.MRBSBooking.Repository.MeetingRequestInterface;
import com.MRBSBooking.Repository.MeetingRoomInterface;
import com.MRBSBooking.Repository.ResourceInterface;

@EnableAutoConfiguration
@Service
@Component
public class AdminDao {
	
	@Autowired
	LoginInterface logininterface;
	
	@Autowired
	MeetingRequestInterface meetingrequestinterface;
	
	@Autowired
	MeetingRoomInterface meetingroominterface;
	
	@Autowired
	ResourceInterface resourceinterface;
	
	//This is the main method to perform add user functionality.
	public String adduser(LoginBean login) {
		// TODO Auto-generated method stub
		logininterface.save(login);
		return Messages.getString("AdminDao.0"); //$NON-NLS-1$
	}
	
	//This is the main method to perform delete user functionality.
	public String deleteuser(LoginBean login) {
		logininterface.deleteById(login.getUsername());
		return Messages.getString("AdminDao.1"); //$NON-NLS-1$
	}
	
	//This is the main method to perform add meeting room functionality.
	public String addmr(MeetingRoom meetingroom) {
		// TODO Auto-generated method stub
		meetingroominterface.save(meetingroom);
		return Messages.getString("AdminDao.2"); //$NON-NLS-1$
	}
	
	//This is the main method to perform add resource functionality.
	public String addresource(Resource resource) {
		// TODO Auto-generated method stub
		resourceinterface.save(resource);
		return Messages.getString("AdminDao.3"); //$NON-NLS-1$
	}

	//This is the main method to perform view all bookings functionality.
	public ArrayList<MeetingRequest> viewrequests() {
		return (ArrayList<MeetingRequest>) meetingrequestinterface.viewrequests();
	}
	
	//This is the main method to perform view new bookings functionality.
	public ArrayList<MeetingRequest> acceptorreject() {
		return (ArrayList<MeetingRequest>) meetingrequestinterface.acceptorreject();
		}
	
	//This is the main method to perform accept a request functionality.
	public String acceptrequest(MeetingRequest meetingrequest) {
		MeetingRequest meetingReq=meetingrequestinterface.findById(meetingrequest.getId()).get();
		meetingReq.setStatus(Messages.getString("AdminDao.4")); //$NON-NLS-1$
		meetingrequestinterface.save(meetingReq);
		return Messages.getString("AdminDao.5"); //$NON-NLS-1$
		}
	
	//This is the main method to perform reject a request functionality.
	public String rejectrequest(MeetingRequest meetingrequest) {
		MeetingRequest meetingReq=meetingrequestinterface.findById(meetingrequest.getId()).get();
		meetingReq.setStatus(Messages.getString("AdminDao.6")); //$NON-NLS-1$
		meetingrequestinterface.save(meetingReq);
		return Messages.getString("AdminDao.7"); //$NON-NLS-1$
		}

	//This is the main method to get resources in select tag functionality.
	public ArrayList<String> getResource() {
		return resourceinterface.getResource();
	}
	
	//This is the main method to perform most used resource functionality.
	public String resourceused(MeetingRequest meetingrequest)
	{
		String resource=meetingrequest.getResource();
		return meetingrequestinterface.resourceused(resource);
	}
	
	//This is the main method to get meetingrooms in select tag functionality.
	public ArrayList<String> getMeetingRoom() {
		return meetingroominterface.getMeetingRoom();
	}
	//This is the main method to perform most used meeting room functionality.
	public String meetingroomused(MeetingRequest meetingrequest)
	{
		String mrname=meetingrequest.getMrname();
		return meetingrequestinterface.meetingroomused(mrname);
	}
	
}
