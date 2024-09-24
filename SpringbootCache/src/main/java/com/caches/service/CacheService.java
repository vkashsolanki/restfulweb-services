package com.caches.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.caches.entity.City;

@Service
public class CacheService {
	
	
	public Map<String, String>  citycode;
	
	
	CacheService(){
		
		citycode = new HashMap<>();
		citycode.put("Gaya", "5000");
	}
	
	public City getCodes(String name) {
		
		return this.name;
		
	}
	
	

}
