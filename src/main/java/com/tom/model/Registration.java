package com.tom.model;

import java.util.*;

public class Registration {
	public static Map<String, UserBean> registered;
	
	public Registration() {
		registered = new HashMap<>();
		UserBean dian = new UserBean("Dian", "123", "Dian", "Guo");
		registered.put("Dian", dian);
	}
	
	/*public static Registration getInstance() {
		if (registration == null) {
			return new Registration();
		} else {
			return registration;
		}
	}*/
	
	public boolean hasUser(String username) {
		return registered.containsKey(username);
	}
	
	public boolean hasUser(UserBean bean) {
		String username = bean.getUsername();
		return registered.containsKey(username);
	}
	
	// Pre-condition: Calling hasUser(LoginBean)
	public void addUser(UserBean bean) {
		String username = bean.getUsername();
		String pwd = bean.getPassword();
		String fname = bean.getFistName();
		String lname = bean.getLastName();
		registered.put(username, new UserBean(username, pwd, fname, lname));
		System.out.println("user " + username + " added");
		// test
		System.out.println("registration: " + registered.hashCode());
		for (String uname : registered.keySet()) {
			System.out.println(registered.get(uname).toString());
		}
	}
	
}
