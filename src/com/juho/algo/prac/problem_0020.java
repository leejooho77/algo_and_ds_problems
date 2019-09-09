package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * 
 * Example 1:
 * Input: 2, [[1,0]] , Output: true
 * Explanation: There are a total of 2 courses to take.
 * 				To take course 1 you should have finished course 0. So it is possible.
 * 
 * Example 2:
 * Input: 2, [[1,0],[0,1]], Output: false
 * Explanation: There are a total of 2 courses to take. 
 * 				To take course 1 you should have finished course 0, and to take course 0 you should
 * 				also have finished course 1. So it is impossible.
 * 
 * @author Juho Lee
 * @since Aug 05, 2019
 */
public class problem_0020 {
	
	/**
	 * First, get the courses that doesn't require any prerequisites.
	 * We can do this by having an array and counting the number of prerequisites to take before take the class.
	 * Using queue, insert the courses that doesn't require prerequisites (whose value is 0).
	 * Then, as we go through the prerequisite classes, we can decrement the class that require this as prerequisite.
	 * As soon as the count is equals to 0, we can add this to the queue and increment @canFinish.
	 * At the end, we can compare whether @canFinish is equal to @numCourses.
	 * If they are same, return true.
	 * Else return false
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return boolean
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] numberOfPrerequisites = new int[numCourses];
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < prerequisites.length; i++) {
			numberOfPrerequisites[prerequisites[i][0]]++;
		}
		for(int i = 0; i < numCourses; i++) {
			if(numberOfPrerequisites[i] == 0)
				queue.offer(i);
		}
		int numCanFinish = queue.size();
		while(!queue.isEmpty()) {
			int prerequisite = queue.poll();
			for(int i = 0; i < prerequisites.length; i++) {
				if(prerequisites[i][1] == prerequisite) {
					numberOfPrerequisites[prerequisites[i][0]]--;
					if(numberOfPrerequisites[prerequisites[i][0]] == 0) {
						numCanFinish++;
						queue.offer(prerequisites[i][0]);
					}
				}
			}
		}
		return (numCanFinish == numCourses);
	}

	/**
	 * Create unidirected graph and check if this graph has a cycle or not.
	 * If it has a cycle, return false.
	 * Else return true.
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return boolean
	 */
	public boolean canFinish_2(int numCourses, int[][] prerequisites) {
		List<List<Integer>> courses = new ArrayList<>();
		for(int i = 0; i < numCourses; i++) {
			courses.add(new ArrayList<>());
		}
		for(int i = 0; i < prerequisites.length; i++) {
			courses.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		int[] numVisits = new int[numCourses];
		for(int i = 0; i < numCourses; i++) {
			if(hasCycle(courses, numVisits, i)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean hasCycle(List<List<Integer>> courses, int[] numVisits, int curr) {
		numVisits[curr] = 1;
		for(int i : courses.get(curr)) {
			if(numVisits[i] == 0) {
				if(hasCycle(courses, numVisits, i)) {
					return true;
				}
			} else if(numVisits[i] == 1)
				return true;
		}
		numVisits[curr] = 2;
		return false;
	}
	
}
