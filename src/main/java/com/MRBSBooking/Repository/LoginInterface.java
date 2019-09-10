package com.MRBSBooking.Repository;

import org.springframework.data.repository.CrudRepository;

import com.MRBSBooking.Bean.LoginBean;

public interface LoginInterface extends CrudRepository<LoginBean, String> {

	
}
 