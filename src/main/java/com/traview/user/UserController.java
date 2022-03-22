package com.traview.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traview.vo.UserVO;

@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserService userService;
    
	@RequestMapping(value = "/user/signUp")
	public @ResponseBody UserVO sign_up(HttpServletRequest request, HttpServletResponse response, @RequestBody UserVO userVO) {
		
		try {
			
			logger.info(userVO.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("왔다감");
		}
		
		return userVO;
	}
	
}
