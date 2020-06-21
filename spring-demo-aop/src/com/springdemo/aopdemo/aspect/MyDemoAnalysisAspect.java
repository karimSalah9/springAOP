package com.springdemo.aopdemo.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springdemo.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoAnalysisAspect {

	// here is where we should add all related advices for logging

	// let's start with @BeforeAdvice

	// @Before("execution( * add*())")
	// @Before("execution(public void
	// com.springdemo.aopdemo.dao.AccountDAO.addAccount())")
	// @Before("execution(public void addAccount())")

	// any method starts with add in any class

	// @Before("execution(public void add*())")

	// for any method with void and no access modifier
	// @Before("execution( void add*())")

	// for any method with no return type and no access modifier
	// @Before("execution( * add*())")

	// for any method with param type of com.springdemo.aopdemo.Account
	// @Before("execution( * add*(com.springdemo.aopdemo.Account))")

	// for any method with param type of com.springdemo.aopdemo.Account and other
	// params
	// @Before("execution( * add*(com.springdemo.aopdemo.Account,..))")

	// for any method with any param
	// @Before("execution( * add*(..))")

	// for any method in specific pacakge
	@Before("execution(* com.springdemo.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {

		System.out.println(" \n==========>  Executing Analysis  Second \n\n ");

		// get method signture
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(" \n==========> The Method Signture is  " + methodSignature);

		// get args of method

		Object[] objects = joinPoint.getArgs();
		for (Object x : objects) {
			System.out.println(x);
			if (x instanceof Account) {
				Account account = (Account) x;
				System.out.println(account.getName());
				System.out.println(account.getLevel());
			}
		}

	}
}
