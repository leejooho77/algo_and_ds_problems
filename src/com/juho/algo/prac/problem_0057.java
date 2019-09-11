package com.juho.algo.prac;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Create a timebased key-value store class TimeMap, that supports two operations.
 * 
 * 	1. set(string key, string value, int timestamp)
 * 		- Stores the key and value, along with the given timestamp.
 * 	2. get(string key, int timestamp)
 * 		- Returns a value such that set(key, value, timestamp_prev) was called previously, 
 * 		  with timestamp_prev <= timestamp.
 * 		- If there are multiple such values, it returns the one with the largest timestamp_prev.
 * 		- If there are no values, it returns the empty string ("").
 * 
 * @author Juho Lee
 * @since Sep 11, 2019
 */
public class problem_0057 {
	
	/**
	 * This class uses @TreeMap to find the largest @timestamp that is smaller than the given @timestamp,
	 * if given @timestamp is not in the @TreeMap by using @floorKey
	 */
	public class TimeMapWithTreeMap {
		
		Map<String, TreeMap<Integer, String>> keyTimeMap;
		
		public TimeMapWithTreeMap() {
	        keyTimeMap = new HashMap<>();
	    }
	    
	    public void set(String key, String value, int timestamp) {
	        keyTimeMap.putIfAbsent(key, new TreeMap<>());
	        keyTimeMap.get(key).put(timestamp, value);
	    }
	    
	    public String get(String key, int timestamp) {
	        if(keyTimeMap.get(key) == null)
	            return "";
	        TreeMap<Integer, String> timeValueMap = keyTimeMap.get(key);
	        if(timeValueMap.floorKey(timestamp) == null) {
	            return "";
	        } else
	            return timeValueMap.get(timeValueMap.floorKey(timestamp));
	    }
	}
	
}
