package com.traview.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traview.vo.UserVO;

@Service("userService")
public class UserService {
	
    @Autowired
    protected UserDAO userDAO;

	public int insertUser(UserVO userVO) throws Exception {
		return userDAO.insertUser(userVO);
	}
	
	public int updateUser(UserVO userVO) throws Exception {
		return userDAO.updateUser(userVO);
	}
	
	public int deleteUser(UserVO userVO) throws Exception {
		return userDAO.deleteUser(userVO);
	}
	
	public UserVO selectUser(UserVO userVO) throws Exception {
		return userDAO.selectUser(userVO);
	}
	
	public List<UserVO> selectUserList(UserVO userVO) throws Exception {
		return userDAO.selectUserList(userVO);
	}
}
