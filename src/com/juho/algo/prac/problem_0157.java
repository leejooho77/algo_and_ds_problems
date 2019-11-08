package com.juho.algo.prac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of building in the form of (left, right, height), return what the skyline should look like.
 * The skyline should be in the form of a list of (x-axis, height),
 * where x-axis is the next point where there is a change in height starting from 0, and height is the new height starting from the x-axis.
 *
 * Example:
 * Input: [[2,9,3],[4,6,5],[5,8,6]]
 * Output: [[2,3],[4,5],[5,6],[9,3],[10,0]]
 *
 *              3 3 3 3
 *            2 3 3 3 3
 *            2 3 3 3 3
 *        1 1 2 3 3 3 3 1
 *        1 1 2 3 3 3 3 1
 *        1 1 2 3 3 3 3 1
 * pos: 1 2 3 4 5 6 7 8 9 10
 *
 * @author Juho Lee
 * @since Nov 8, 2019
 */
public class problem_0157 {

    public class Building {
        public int start;
        public int end;
        public int height;

        public Building(int start, int end, int height) {
            this.start = start;
            this.end = end;
            this.height = height;
        }
    }

    public List<Integer> generateSkyline(int[][] buildingInfo) {
        List<Building> buildings = new ArrayList<>();
        for(int[] building : buildingInfo) buildings.add(new Building(building[0], building[1], building[2]));
        Collections.sort(building)
        return null;
    }

}