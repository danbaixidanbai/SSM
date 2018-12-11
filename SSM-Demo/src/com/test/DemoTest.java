package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.BookService;


public class DemoTest {
	
	ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
	@Test
	public void show(){
		 BookService bookService=ac.getBean(BookService.class);
		int price=bookService.findBookPriceByIsbn("10001");
		System.out.println(price);
	}
	
	@Test 
	public void show2(){
		BookService bookService=ac.getBean(BookService.class);
		bookService.BuyBooks("10002", "asd");
	}
}
