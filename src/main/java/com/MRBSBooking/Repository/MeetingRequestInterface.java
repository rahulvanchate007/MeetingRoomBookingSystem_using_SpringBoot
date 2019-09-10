package com.MRBSBooking.Repository;

import java.util.ArrayList;
import org.springframework.data.repository.query.Param;

import com.MRBSBooking.Bean.MeetingRequest;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MeetingRequestInterface extends CrudRepository <MeetingRequest, Integer> {
	
	//This Query is for Viewing All the Requests.
	@Query("select m from MeetingRequest m")	
	public ArrayList<MeetingRequest> viewrequests();
	
	//This Query is for View All the new Requests.
	@Query("select m from MeetingRequest m where m.status='new'")
	public ArrayList<MeetingRequest> acceptorreject();
	
	//This Query is for the user to view his Request History.
	@Query("select m from MeetingRequest m where m.user=:user")
		public ArrayList<MeetingRequest> findMeetingRequestbyUser(@Param("user") String user);

	//This Query is for The Most Used Resource.
	@Query("select count(s) from MeetingRequest s where s.resource=?1")
	public String resourceused(String resource);
	
	//This Query is for the Most Used Meeting Room.
	@Query("select count(s) from MeetingRequest s where s.mrname=?1")
	public String meetingroomused(String mrname);
}
