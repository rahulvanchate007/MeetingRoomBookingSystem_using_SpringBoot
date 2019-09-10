package com.MRBSBooking.Repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.MRBSBooking.Bean.Resource;

public interface ResourceInterface extends CrudRepository<Resource, String> {

	//This Query is for getting the resources in the select tag in JSP.
	@Query("select m.resourcename from Resource m")
	public ArrayList<String> getResource();

	
}
