package com.example.demo.RestController;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.MeetingRequest;
import com.example.demo.Dao.UserDao;
import com.example.demo.Repository.MeetingRequestInterface;

@RestController
@RequestMapping("userfunctionalities")
public class UserRestController {

	@Autowired
	UserDao userdao;
	@Autowired	
	MeetingRequestInterface meetingrequestinterface;

	//This method is called by the UserController, This method goes to [getMeetingRoom] method in UserDao.
@RequestMapping(value = "/getmeetingroom", method = RequestMethod.GET)
public ArrayList<String> getmeetingroom()
{
return userdao.getMeetingRoom();
}

	//This method is called by the UserController, This method goes to [getResource] method in UserDao.
@RequestMapping(value = "/getresource", method = RequestMethod.GET)
public ArrayList<String> getresource()
{
return userdao.getResource();
}

	//This method is called by the UserController, This method goes to [requestmeetingroom] method in UserDao.
@RequestMapping(value = "/requestmeetingroom", method = RequestMethod.POST)
public String requestmeetingRoom(@RequestBody MeetingRequest meetingrequest)
{
String status=userdao.requestMeetingRoom(meetingrequest);
return status;
}

//This method is called by the UserController, This method goes to [FindMeetingRequestByUser] method in UserDao.
@RequestMapping(value = "/cancelview/{user}", method = RequestMethod.GET)
public ArrayList<MeetingRequest> cancelview(@PathVariable("user")String user)
{
return userdao.findMeetingRequestbyUser(user);
}

//This method is called by the UserController, This method goes to [cancelrequest] method in UserDao.
@RequestMapping(value = "/cancelrequest", method = RequestMethod.POST)
public String cancelrequest(@RequestBody MeetingRequest meetingrequest) {
String status=userdao.cancelrequest(meetingrequest);
return status;
}

}