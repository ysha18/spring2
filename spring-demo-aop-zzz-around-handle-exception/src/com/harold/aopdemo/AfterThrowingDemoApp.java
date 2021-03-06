package com.harold.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.harold.aopdemo.dao.AccountDao;

public class AfterThrowingDemoApp {

	public static void main (String[] args) {
		// read spring config
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get bean from spring container
		AccountDao accoutnDao = context.getBean(AccountDao.class);
		
		// call  method to find accounts
		List<Account> myAccounts = null;
		
		try	{
			// boolean to simulate exceptions
			boolean tripWire = true;
			myAccounts = accoutnDao.getAccounts(tripWire);
		
		}catch (Exception e) {
			System.out.println("\n\n Main program: Caught exception: "+ e);
		}
		// display accounts
		System.out.println("\n\n Main program: AfterThrowing ");
		System.out.println("----");
		System.out.println(myAccounts);
		System.out.println("\n");
		
		
		// closse context
		context.close();
	}
}
