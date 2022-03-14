package com.traview.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
	
    @Autowired
    protected UserDAO userDAO;

	public String selectTime() throws Exception {
		return userDAO.selectTime();
	}
}
