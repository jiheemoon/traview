package com.traview.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("homeService")
public class HomeService {
	
    @Autowired
    protected HomeDAO homeDAO;

	public String selectTime() throws Exception {
		return homeDAO.selectTime();
	}
}
