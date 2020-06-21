package com.springdemo.aopdemo;

public class Account {

	private String name;
	private String level;

	public Account() {

	}

	public Account(String name, String level) {

		this.name = name;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
