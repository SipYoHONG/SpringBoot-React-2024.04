package com.example.project.reactProject.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.project.reactProject.entity.User;

@Mapper
public interface UserDao {

		@Select("select * from users where isDeleted=0 order by regDate desc"
				+ " limit #{count} offset #{offset}")
		List<User> getUserList(int count, int offset);
		
	}
