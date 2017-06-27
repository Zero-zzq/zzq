package com.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zzq.ssh.service.UserServiceImp;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations={"classpath:applicationContext.xml"})  
public class SpringTest{  
    @Resource(name="userServiceImp")  
    private UserServiceImp userService; 
    @Test   
    public void testServie1(){  
    	userService.add();
    }
    @Test   
    public void testServie2(){  
    	userService.queryList();
    }
    @Test   
    public void testServie3(){  
    	try {
			userService.addTwo(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}  