package com.wang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wang.pojo.Users;
import com.wang.serice.UsersService;

@RestController
public class UserControler {
	@Autowired
	private UsersService usersService;
	@Autowired
	private DiscoveryClient client;
	
	//添加熔断
	 
	@RequestMapping("/get/{id}")
	@HystrixCommand(fallbackMethod="HystrixgetUsers")
	public Users getUsers(@PathVariable int id) throws Exception{
		Users users=usersService.selectByPrimaryKey(id);
	 if(users==null){
		 throw new Exception("null -->id");
	 }
		return users;
	}
	
	//备选方案
	 
	public Users HystrixgetUsers(int id){
		 
		return new Users(id, "不存在id", id, "2020年4月24日13:01:45");
	}
	
	
	@RequestMapping("/getlist")
	public List<Users> getUsersList( ){
		 List<Users> users=usersService.selectALL();
		return users;
	}
	
	@RequestMapping("/getServer")
	@ResponseBody
	public Object discotrey(){
		
		List<String >list=client.getServices();
		 for (String string : list) {
			System.out.println(string);
		}
		 List<ServiceInstance>serv= client.getInstances("SPRINGCLOUD");
		 for (ServiceInstance ser : serv) {
			System.out.println(ser.getHost()+"\t"+ser.getInstanceId()+"\t"+ser.getPort()+"\t"+ser.getScheme());
		}
		 return this.client;
	}
	
	
	
}
