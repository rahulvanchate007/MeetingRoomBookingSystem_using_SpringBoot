package com.MRBSBooking;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	  public boolean validateUser(String username, String password) {
	        // in28minutes, dummy
	        return username.equalsIgnoreCase("rahul") && password.equalsIgnoreCase("qazplm");
	    }

	
}
