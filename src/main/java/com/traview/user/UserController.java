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

import common.vo.ResultVO;

@Controller
public class UserController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
    private UserService userService;

	@ResponseBody 
	@RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
	public ResultVO<UserVO> user_signUp(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		ResultVO<UserVO> resultVO = new ResultVO<UserVO>();
		try {
			resultVO.setErrorCode(userService.insertUser(userVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
			resultVO.setResultStr("이미 존재하는 아이디입니다.");
		}
		
		return resultVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/user/signIn", method = RequestMethod.POST)
	public ResultVO<UserVO> user_signIn(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		ResultVO<UserVO> resultVO = new ResultVO<UserVO>();
		try {
			resultVO.setData(userService.selectUser(userVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/user/updateUser", method = RequestMethod.POST)
	public ResultVO<UserVO> user_updateUser(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		ResultVO<UserVO> resultVO = new ResultVO<UserVO>();
		try {
			resultVO.setErrorCode(userService.updateUser(userVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/user/deleteUser", method = RequestMethod.POST)
	public ResultVO<UserVO> user_deleteUser(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		ResultVO<UserVO> resultVO = new ResultVO<UserVO>();
		try {
			resultVO.setErrorCode(userService.deleteUser(userVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}
	
	@ResponseBody 
	@RequestMapping(value = "/user/selectUser", method = RequestMethod.POST)
	public ResultVO<UserVO> user_selectUser(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		ResultVO<UserVO> resultVO = new ResultVO<UserVO>();
		try {
			resultVO.setData(userService.selectUser(userVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}

	@ResponseBody 
	@RequestMapping(value = "/user/selectUserList", method = RequestMethod.POST)
	public ResultVO<UserVO> user_selectUserList(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {

		logger.info(userVO.toString());
		ResultVO<UserVO> resultVO = new ResultVO<UserVO>();
		try {
			resultVO.setDataList(userService.selectUserList(userVO));
		} catch (Exception e) {
			e.printStackTrace();
			resultVO.setErrorCode(-1);
		}
		
		return resultVO;
	}
	
}
