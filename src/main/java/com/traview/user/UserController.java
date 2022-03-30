package com.traview.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traview.vo.UserVO;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserService userService;

	@ResponseBody 
	@RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
	public UserVO user_signUp(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		try {
			int result = userService.insertUser(userVO);
			userVO.setErrorCode(result);
		} catch (Exception e) {
			userVO.setErrorCode(-1);
			e.printStackTrace();
		}
		
		return userVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/user/signIn", method = RequestMethod.POST)
	public UserVO user_signIn(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		UserVO resultUserVO = new UserVO();
		try {
			resultUserVO = userService.selectUser(userVO);
			resultUserVO.setErrorCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			resultUserVO.setErrorCode(-1);
		}
		
		return resultUserVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
	public UserVO user_updateUser(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		try {
			int result = userService.updateUser(userVO);
			userVO.setErrorCode(result);
		} catch (Exception e) {
			e.printStackTrace();
			userVO.setErrorCode(-1);
		}
		
		return userVO;
	}
	
	
	
}
