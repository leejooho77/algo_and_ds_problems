package com.juho.algo.prac;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a hash table where the key is a course code, 
 * and the value is a list of all the course codes that are prerequisites for the key. 
 * Return a valid ordering in which we can complete the courses. If no such ordering exists, return NULL.
 * 
 * Example:
 * {
 * 'CSC300': ['CSC100', 'CSC200'],
 * 'CSC200': ['CSC100'], 
 * 'CSC100': []
 * }
 * 
 * This input should return the order that we need to take these courses:
 * ['CSC100', 'CSC200', 'CSCS300']
 * 
 * @author leejooho77
 * @since Aug 14, 2019
 */
public class problem_0028 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		int[] numberOfPrerequisites = new int[numCourses];
		for(int i = 0; i < prerequisites.length; i++) {
			numberOfPrerequisites[prerequisites[i][0]]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < numCourses; i++) {
			if(numberOfPrerequisites[i] == 0)
				queue.offer(i);
		}
		int canFinish = queue.size();
		while(!queue.isEmpty()) {
			int currCourse = queue.poll();
			for(int i = 0; i < prerequisites.length; i++) {
				if(currCourse == prerequisites[i][1]) {
					if(--prerequisites[i][0] == 0) {
						queue.offer(prerequisites[i][0]);
						canFinish++;
					}
				}
			}
		}
		return (canFinish == numCourses) ? result : null;
	}
	
}
