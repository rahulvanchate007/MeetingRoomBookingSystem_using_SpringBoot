package com.MRBSBooking.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MRBSBooking.Bean.MeetingRoom;

public interface MeetingRoomInterface extends CrudRepository<MeetingRoom, String>{

	//This Query is for getting the meeting room names in the select tag in JSP.
@Query("select m.meetingroomname from MeetingRoom m")
public ArrayList<String> getMeetingRoom();

}
