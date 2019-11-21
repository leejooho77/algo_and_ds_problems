package com.juho.algo.prac;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it.
 *
 * input: dict =
 *      {
 *             "Key1" : "1",
 *             "Key2" : {
 *                 "a" : "2",
 *                 "b" : "3",
 *                 "c" : {
 *                     "d" : "3",
 *                     "e" : "1"
 *                 }
 *             }
 *       }
 * output: {
 *             "Key1" : "1",
 *             "Key2.a" : "2",
 *             "Key2.b" : "3",
 *             "Key2.c.d" : "3",
 *             "Key2.c.e" : "1"
 *         }
 *
 * @author Juho Lee
 * @since Nov 20, 2019
 */
public class problem_0177 {

    public HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        HashMap<String, String> result = new HashMap<>();
        flattenDictionary(result, dict, new StringBuilder());
        return result;
    }

    public void flattenDictionary(HashMap<String, String> result, HashMap<String, Object> dict, StringBuilder key) {
        for(Map.Entry<String, Object> entry : dict.entrySet()) {
            Object value = entry.getValue();
            key.append(".").append(entry.getKey());
            if(value instanceof String) {
                result.put(key.substring(1), (String) value);
            } else {
                flattenDictionary(result, (HashMap<String, Object>) value, key);
            }
            key.delete(key.lastIndexOf("."), key.length());
        }
    }

}
