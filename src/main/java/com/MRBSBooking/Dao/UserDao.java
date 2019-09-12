package com.MRBSBooking.Dao;

import java.util.ArrayList;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.MRBSBooking.Bean.MeetingRequest;
import com.MRBSBooking.Repository.MeetingRequestInterface;
import com.MRBSBooking.Repository.MeetingRoomInterface;
import com.MRBSBooking.Repository.ResourceInterface;

@EnableAutoConfiguration
@Service
@Component
public class UserDao {

@Autowired
MeetingRoomInterface meetingroominterface;
@Autowired
ResourceInterface resourceinterface;
@Autowired 
MeetingRequestInterface meetingrequestinterface;

public String requestMeetingRoom(MeetingRequest meetingrequest) {
meetingrequestinterface.save(meetingrequest);
return Messages.getString("UserDao.0"); //$NON-NLS-1$
}

//This is the main method to get meetingrooms in select tag functionality.
public ArrayList<String> getMeetingRoom() {
return meetingroominterface.getMeetingRoom();
}

//This is the main method to get resources in select tag functionality.
public ArrayList<String> getResource() {
return resourceinterface.getResource();
}

//This is the main method to perform view booking history for user.
public ArrayList<MeetingRequest> findMeetingRequestbyUser(String user) {
	System.out.println((meetingrequestinterface.findMeetingRequestbyUser(user)));
	return new ArrayList<MeetingRequest> (meetingrequestinterface.findMeetingRequestbyUser(user));
	}

//This is the main method to perform cancel request by a user.
public String cancelrequest(MeetingRequest meetingrequest) {
	MeetingRequest meetingRequest=meetingrequestinterface.findById(meetingrequest.getId()).get();
	meetingRequest.setStatus(Messages.getString("UserDao.1")); //$NON-NLS-1$
	meetingrequestinterface.save(meetingRequest);
	return Messages.getString("UserDao.2"); //$NON-NLS-1$
	}

}


