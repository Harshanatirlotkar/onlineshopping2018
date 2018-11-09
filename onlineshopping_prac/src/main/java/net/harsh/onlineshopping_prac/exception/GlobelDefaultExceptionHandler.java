package net.harsh.onlineshopping_prac.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobelDefaultExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	
	public ModelAndView noHandlerFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not constructed");
		mv.addObject("errorDescription", "The page you are looking for is not availble ");
		mv.addObject("title", "404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	
	public ModelAndView handlerProductNotFoundException(){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Product not available");
		mv.addObject("errorDescription", "Product you are looking for is not availble ");
		mv.addObject("title", "Product unavailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	
	public ModelAndView handlerException(Exception ex){
		
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your administrator!!");
		/* only for debugging */
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription", sw);
		//mv.addObject("errorDescription", ex.toString());
		mv.addObject("title", "Error");
		return mv;
	}
}
