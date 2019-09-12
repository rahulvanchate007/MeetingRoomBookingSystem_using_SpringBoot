package com.MRBSBooking.Dao;
import java.util.Optional;

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
		Optional<LoginBean> list =logininterface.findById(loginbean.getUsername());
		if (list.isPresent() && list.get().getUsername().equals(loginbean.getUsername()) && list.get().getPassword().equals(loginbean.getPassword())) {
				if (list.get().getRole().equals(Messages.getString("LoginDao.0"))) { //$NON-NLS-1$
					status = Messages.getString("LoginDao.1"); //$NON-NLS-1$
				} else if (list.get().getRole().equals(Messages.getString("LoginDao.2"))) { //$NON-NLS-1$
					status = Messages.getString("LoginDao.3"); //$NON-NLS-1$
				}
			}
		else
			status=Messages.getString("LoginDao.4"); //$NON-NLS-1$
		return status;
	}
}
