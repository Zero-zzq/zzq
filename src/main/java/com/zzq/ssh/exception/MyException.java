package com.zzq.ssh.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyException implements HandlerExceptionResolver {

	//@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		String msg= ex.getMessage();
		
		System.out.println(msg);
		
		request.setAttribute("errorMsg", msg);
		ModelAndView model=new ModelAndView();
		model.setViewName("error");
		//通过log4j日志组件记录下来
		
		return model;
	}

}
