package com.library.main;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {
    public static void main(String[] args) {
    	 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
         System.out.println("Spring context loaded successfully!");
         ((ClassPathXmlApplicationContext) context).close();
    }
}
