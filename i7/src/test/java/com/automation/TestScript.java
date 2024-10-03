package com.automation;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class TestScript {

	public static void main(String[] args) {

		Map<String, String> map = new Hashtable<String, String>();

		System.out.println(map.isEmpty());

		System.out.println(map.size());
		
		map.put("TestScript","TC001");
		
		map.put("UserName","Admin");
		
		map.put("Password","Admin123");
		
		System.out.println(map);
		
		System.out.println(map.get("Password"));
	}

}
