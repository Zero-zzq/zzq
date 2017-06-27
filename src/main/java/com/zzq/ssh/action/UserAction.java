package com.zzq.ssh.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zzq.ssh.service.IUserService;
@Controller
@RequestMapping("/test")
public class UserAction {

	@Resource(name="userServiceImp")
	private IUserService userService;
	
	@RequestMapping("/test1")
	public String test(){
		System.out.println("来了");
		userService.add();
		return "success";
	}
	 @RequestMapping("add17")
	 public String add7(){
		 System.out.println("add17");
		 String a=null;
		 a.equals("123");
		 return "success";
	 }
	 @ExceptionHandler(value={NullPointerException.class})
	 public String exceptionExecute(Exception ex,HttpServletRequest request){
		 System.out.println("空指针异常");
		 return "error";
	 }
}
