package com.springdemo.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springdemo.aopdemo.Account;

@Component

public class AccountDAO {

	public String getFourtune(boolean test) {

		if (test) {

			throw new RuntimeException("To make an exception !");
		}
		String res = "today is your luckyday!";
		return res;
	}
	// method for find all accounts

	public List<Account> findAllAccounts(boolean test) {
		if (test) {
			throw new RuntimeException("To make an exception !");

		}
		List<Account> accounts = new ArrayList<Account>();
		Account account1 = new Account("karim", "high");
		Account account2 = new Account("salah", "gold");
		Account account3 = new Account("mohamed", "silver");
		Account account4 = new Account("ezzat", "low");
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		return accounts;

	}

	public void addAccount() {

		System.out.println("\n" + getClass() + " \n====> Do Some DB Work Add Account \n");

	}

	/**
	 * for method start with Add public void addTest() {
	 * 
	 * System.out.println("\n" + getClass() + " \n====> to test any method starts
	 * with (add) \n");
	 * 
	 * }
	 *
	 */
	/**
	 * 
	 * 
	 * // for different return type method public String addTest() {
	 * 
	 * System.out.println("\n" + getClass() + " \n====> to test any method starts
	 * with (add) \n"); return "koko"; }
	 **/
	// for any method that take param from type Account
	public void addTest(Account account, boolean b) {

		System.out.println("\n" + getClass() + " \n====> for any method that take param from type Accoun \n");

	}

}
