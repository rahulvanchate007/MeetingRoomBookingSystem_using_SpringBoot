package com.MRBSBooking;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

	  public boolean validateUser(String username, String password) {
	        // in28minutes, dummy
	        return username.equalsIgnoreCase(Messages.getString("LoginService.0")) && password.equalsIgnoreCase(Messages.getString("LoginService.1")); //$NON-NLS-1$ //$NON-NLS-2$
	    }

	
}
