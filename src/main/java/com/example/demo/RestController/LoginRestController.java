package com.example.demo.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Bean.LoginBean;
import com.example.demo.Dao.LoginDao;

@RestController
@RequestMapping("/myresource")

public class LoginRestController {

	@Autowired
	LoginDao logindao;
	
	//This method is called by the LoginController, This method goes to [loginRepository] method in LoginDao.
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@RequestBody LoginBean login) {
	String status=logindao.loginRepository(login);
	return status;
	}
}

