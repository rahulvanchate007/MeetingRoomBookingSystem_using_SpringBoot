package com.example.demo.Dao;

import java.util.ArrayList;

import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;

import com.example.demo.Bean.MeetingRequest;
import com.example.demo.Repository.MeetingRequestInterface;
import com.example.demo.Repository.MeetingRoomInterface;
import com.example.demo.Repository.ResourceInterface;

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
return "REQUESTED";
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
	meetingRequest.setStatus("cancelled");
	meetingrequestinterface.save(meetingRequest);
	return "cancelled";
	}

}


