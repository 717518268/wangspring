package com.wang.dao;

import com.wang.pojo.Users;


import java.util.List;
 

public interface UsersMapper {
	
	public Users selectByPrimaryKey(int id);
	
	public List<Users> selectALL();
	
	public int deleteByPrimaryKey(int id);
	
	public int insert(Users users);
	
	public int countByExample();
	
	public int updateByPrimaryKey(Users users);
	
	
}