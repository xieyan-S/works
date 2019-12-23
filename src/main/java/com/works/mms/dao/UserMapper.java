package com.works.mms.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.works.mms.entity.User;

@Mapper
public interface UserMapper {

	@Select("select * from user where username = #{username} and password = #{password}")
	User selectByUsernameAndPassword(User user);
	
	@Select("select * from user where username = #{username}")
	User selectByUsername(User user);

	@Insert("insert into user(username,password) values(#{username},#{password})")
	int insert(User user);

	
}
