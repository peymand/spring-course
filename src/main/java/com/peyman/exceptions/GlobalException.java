package com.peyman.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalException implements HandlerExceptionResolver {

	@ExceptionHandler(NoHandlerFoundException.class)
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
		
		
		ModelAndView modelAndView=new ModelAndView();
		
		CustomError error=new CustomError();
		error.setMessage("You are trying to access an unauthorized page.Please enter a valid url.");
		modelAndView.addObject("customError", error);
		modelAndView.setViewName("error_page");
		return modelAndView;
	}
	
	

	
}
