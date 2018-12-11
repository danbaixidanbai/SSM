package com.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.service.BookService;

@Controller
public class BookHandler {
	
	@Autowired
	private BookService bookService;
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView getExcetion(Exception e){
		System.out.println("arithmeticException:"+e);
		ModelAndView mv=new ModelAndView();
		 mv.setViewName("error");
		 mv.addObject("e", e.getMessage());
		return mv;
	}
	
	@RequestMapping("/buybook")
	public ModelAndView buyBook(@RequestParam("userName") String userName,@RequestParam("isbn") String isbn){
		 bookService.BuyBooks(isbn, userName);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("success");
		return mv;
	}
}
