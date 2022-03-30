package com.traview.home;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.traview.vo.UserVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    private HomeService homeService;
  	
	@RequestMapping("/favicon.ico")
	public String favicon1() {
		return "forward:/resources/img/fav.ico";
	}
	
	@RequestMapping("**/favicon.ico")
	public String favicon2() {
		return "forward:/resources/img/fav.ico";
	}
	
	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		String s = "";
		try {
			s = homeService.selectTime();
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
	
//	@ResponseBody 
//	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
//	public UserVO sign_up(@RequestBody UserVO userVO, HttpServletRequest req, HttpServletResponse res) {
//		
//		try {
//			logger.info(userVO.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return userVO;
//	}
}
