package com.MRBSBooking.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

import com.MRBSBooking.Bean.LoginBean;
import com.MRBSBooking.Repository.LoginInterface;


@EnableAutoConfiguration
@Service
public class LoginDao {

	@Autowired
	LoginInterface logininterface;

	//This is the main method that performs Login Validation.
	public String loginRepository(LoginBean loginbean) {
		String status = null;
		LoginBean list =logininterface.findById(loginbean.getUsername()).get();
		if (list.getUsername().equals(loginbean.getUsername()) && list.getPassword().equals(loginbean.getPassword())) {
				if (list.getRole().equals("admin")) {
					status = "admin";
				} else if (list.getRole().equals("user")) {
					status = "user";
				}
			}
		return status;
	}
}
