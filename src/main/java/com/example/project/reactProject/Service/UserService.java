package com.example.project.reactProject.Service;

import java.util.List;

import com.example.project.reactProject.entity.User;

public interface UserService {
	
	    List<User> getAllUsers();
	    
	    User getUserById(Long id);
	    
	    User addUser(User user);
	    
	    User updateUser(User user);
	    
	    void deleteUser(Long id);
	}
