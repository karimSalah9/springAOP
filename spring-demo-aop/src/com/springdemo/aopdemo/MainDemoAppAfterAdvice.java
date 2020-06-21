package com.springdemo.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springdemo.aopdemo.dao.AccountDAO;
import com.springdemo.aopdemo.dao.MembershipDAO;

public class MainDemoAppAfterAdvice {

	public static void main(String[] args) {

		// read Spring Config JAva Class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		MembershipDAO dao = context.getBean("membershipDAO", MembershipDAO.class);

		// call bussiness method from another DAO using @After Advice

		List<Account> accounts = null;
		try {
			boolean test = false;
			accounts = accountDAO.findAllAccounts(test);
		} catch (Exception e) {
			System.out.println("\n\n main App Exception is : " + e);
		}

		System.out.println("\n\n List Of our Accounts in main Class : ");
		System.out.println(accounts);
		System.out.println("\n\n");
		// close spring context
		context.close();
	}

}
