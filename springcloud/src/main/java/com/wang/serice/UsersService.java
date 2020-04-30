package com.wang.serice;

import com.wang.pojo.Users;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
 
 
public interface UsersService {
 
	public Users selectByPrimaryKey(int id);
	
	public List<Users> selectALL();
	
	public int deleteByPrimaryKey(int id);
	
	public int insert(Users users);
	
	public int countByExample();
	
	public int updateByPrimaryKey(Users users);
	
	
}