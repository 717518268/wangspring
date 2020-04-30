package com.wang.serice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.dao.UsersMapper;
import com.wang.pojo.Users;
import com.wang.serice.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public Users selectByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return usersMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Users> selectALL() {
		// TODO Auto-generated method stub
		return usersMapper.selectALL();
	}

	@Override
	public int deleteByPrimaryKey(int id) {
		// TODO Auto-generated method stub
		return usersMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Users users) {
		// TODO Auto-generated method stub
		return usersMapper.insert(users);
	}

	@Override
	public int countByExample() {
		// TODO Auto-generated method stub
		return usersMapper.countByExample();
	}

	@Override
	public int updateByPrimaryKey(Users users) {
		// TODO Auto-generated method stub
		return usersMapper.updateByPrimaryKey(users);
	}

}
