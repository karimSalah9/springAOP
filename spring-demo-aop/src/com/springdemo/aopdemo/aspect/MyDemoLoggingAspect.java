package com.springdemo.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springdemo.aopdemo.Account;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

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

		System.out.println(" \n==========>  Executing at before addAccount()) \n\n ");
		// get method signture
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(" \n==========> The Method Signture is  " + methodSignature);
		// get args of method

		Object[] objects = joinPoint.getArgs();
		for (Object x : objects) {
			System.out.println(x);
		}

	}

	@AfterReturning(pointcut = "execution(* com.springdemo.aopdemo.dao.AccountDAO.findAllAccounts(..))", returning = "result")

	public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
		// print which method we are in
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n\n executing after returninig method  " + methodName);
		// print result object
		System.out.println("\n\n executing after returninig method the result is :   " + result);

		if (result != null) {
			Account account = result.get(0);
			account.setLevel("opaaaaaaaa");

		}
		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}

	}

	@AfterThrowing(pointcut = "execution(* com.springdemo.aopdemo.dao.AccountDAO.findAllAccounts(..))", throwing = "ex")
	public void afterThrwoingExceptionFindAllAccounts(JoinPoint joinPoint, Throwable ex) {

		// log method signture
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n\n executing after throwing error  method  " + methodName);
		// log the exception
		System.out.println("The exception is : " + ex);

	}

	@After("execution(* com.springdemo.aopdemo.dao.AccountDAO.findAllAccounts(..))")
	public void afterFindAllAccounts(JoinPoint joinPoint) {

		// log method signture
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n\n executing after   method  " + methodName);
	}

	@Around("execution(* com.springdemo.aopdemo.dao.AccountDAO.getFourtune(..))")
	public Object getArround(ProceedingJoinPoint joinPoint) throws Throwable {
		// log method signture
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n\n executing arround   method  " + methodName);
		// start time stamp
		long start = System.currentTimeMillis();
		Object result = null;
		// now let's execute the method
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			// result = "nothing to tell you about today!";
			// this for rethrow the exception instead of modifying
			throw e;
		}
		// end time stamp
		long end = System.currentTimeMillis();

		// duration of process
		long duration = end - start;
		System.out.println("The duration is : " + duration + "milliSeconds");

		return result;
	}

}
