package com.example.project.reactProject.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project.reactProject.Dao.UserDao;
import com.example.project.reactProject.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserDao userDao;

	@Override
	public List<User> getUserList(int page) {
		int offset = (page - 1) * COUNT_PER_PAGE;
		return userDao.getUserList(COUNT_PER_PAGE, offset);
	}

}
