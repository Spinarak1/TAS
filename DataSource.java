package com.packt.project1.controller;

import java.util.HashMap;

import com.packt.project1.controller.User;

public class DataSource {

	private HashMap<String, String> userSource;

	public DataSource() {
		userSource = new HashMap<String, String>();
		generateTestData();
	}

	public void register(String name, String password) {
		userSource.put(name, password);
	}

	public boolean userExists(User user) {
		String passwordFromSource = userSource.get(user.getName());
		if(passwordFromSource != null) {
			return user.getPassword().equals(passwordFromSource);
		}else
			return false;
	}

	private void generateTestData() {
		userSource.put("admin", "test");
		userSource.put("user", "passUser");
	}
}