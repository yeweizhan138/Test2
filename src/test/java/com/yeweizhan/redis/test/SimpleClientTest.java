package com.yeweizhan.redis.test;

import java.util.Date;

import org.junit.Test;

import com.wanzhon.model.User;
import com.yeweizhan.redis.RedisClient;

public class SimpleClientTest {
	  
	  @Test
	  public void userCache(){
	    
	    //向缓存中保存对象
	    User user = new User();
	    user.setId(1);
	    user.setBirth(new Date());
	    //调用方法处理
	    boolean reusltCache = RedisClient.set("user", user);
	    if (reusltCache) {
	      System.out.println("向缓存中保存对象成功。");
	    }else{
	      System.out.println("向缓存中保存对象失败。");
	    }
	  }
	  
	  
	  @Test
	  public void getUserInfo(){
	    
	    User user = RedisClient.get("user",User.class);
	    if(user != null){
	      System.out.println("从缓存中获取的对象，" + user.getId() + "@" + user.getBirth());
	    }
	    
	  }
	  
	  

	}