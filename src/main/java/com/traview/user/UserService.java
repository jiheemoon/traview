package com.traview.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traview.vo.UserVO;

@Service("userService")
public class UserService {
	
    @Autowired
    protected UserDAO userDAO;

	public int insertUser(UserVO userVO) {
		return userDAO.insertUser(userVO);
	}
}
