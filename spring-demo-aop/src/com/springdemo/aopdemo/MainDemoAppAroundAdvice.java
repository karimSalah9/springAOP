package com.springdemo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aopdemo.dao.AccountDAO;
import com.springdemo.aopdemo.dao.MembershipDAO;

public class MainDemoAppAroundAdvice {

	public static void main(String[] args) {

		// read Spring Config JAva Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call bussiness method from another DAO using @Around Advice
		 
		try {
			System.out.println("the Method in main");
			System.out.println(accountDAO.getFourtune(true));

		} catch (Exception e) {
			System.out.println("there is exception in main method " + e);
		}
		context.close();
	}

}
