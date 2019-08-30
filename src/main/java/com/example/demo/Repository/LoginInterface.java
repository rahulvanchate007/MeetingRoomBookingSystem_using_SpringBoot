package com.example.demo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Bean.LoginBean;

public interface LoginInterface extends CrudRepository<LoginBean, String> {

	
}
 