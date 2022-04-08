package com.traview.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("homeService")
public class HomeService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @Autowired
    protected HomeDAO homeDAO;

	public String selectTime() throws Exception {
		return homeDAO.selectTime();
	}
}
