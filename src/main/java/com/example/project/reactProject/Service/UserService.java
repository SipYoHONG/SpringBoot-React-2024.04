package com.example.project.reactProject.Service;

import java.util.List;

import com.example.project.reactProject.entity.User;

public interface UserService {
	
	public static final int COUNT_PER_PAGE = 10;
	
	List<User> getUserList(int page);
	    
}
