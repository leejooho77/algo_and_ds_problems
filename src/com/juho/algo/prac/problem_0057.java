package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
 * Note:
 * 	1. All key/value strings are lowercase.
 * 	2. All key/value strings have length in the range [1, 100]
 * 	3. The timestamps for all TimeMap.set operations are strictly increasing.
 * 	4. 1 <= timestamp <= 10^7
 * 	5. TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case.
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
	
	/**
	 * This class is a wrapper class for @timestamp and @value pair
	 */
	public class TimeValue {
		int time;
		String value;
		public TimeValue(int time, String value) {
			this.time = time;
			this.value = value;
		}
	}
	
	/**
	 * This class uses @BinarySearch to find the largest @timestamp that is smaller than the given @timestamp.
	 * Since all the @timestamps are increasing order, we can apply @BinarySearch here.
	 * If we find the mid that has same @timestamp, return the mid.
	 * Else if we find the mid that has higher @timestamp, set high to mid - 1.
	 * Else we save this pair and set low to mid + 1.
	 */
	public class TimeMapWithBinarySearch {
		
		Map<String, List<TimeValue>> keyTimeValueMap;
		
		public TimeMapWithBinarySearch() {
	        keyTimeValueMap = new HashMap<>();
	    }
	    
	    public void set(String key, String value, int timestamp) {
	    	keyTimeValueMap.putIfAbsent(key, new ArrayList<>());
	    	keyTimeValueMap.get(key).add(new TimeValue(timestamp, value));
	    }
	    
	    public String get(String key, int timestamp) {
	        if(keyTimeValueMap.get(key) == null)
	        	return "";
	        else
	        	return binarySearch(keyTimeValueMap.get(key), timestamp);
	    }
	    
	    private String binarySearch(List<TimeValue> list, int timestamp) {
	    	int low = 0, high = list.size() - 1;
            TimeValue result = null;
	    	while(low <= high) {
	    		int mid = low + (high - low)/2;
	    		TimeValue pair = list.get(mid);
	    		if(pair.time == timestamp)
	    			return pair.value;
	    		else if(pair.time > timestamp)
	    			high = mid - 1;
	    		else {
                    result = list.get(mid);
	    			low = mid + 1;
                }
	    	}
	    	return (result == null) ? "" : result.value;
	    }
	}
	
}
