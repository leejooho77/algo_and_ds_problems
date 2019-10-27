package com.juho.algo.prac;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A robot on an infinite grid starts at point (0, 0) and faces north.
 * The robot can receive one of three possible types of commands:
 *  1. -2: turn left 90 degrees
 *  2. -1: turn right 90 degrees
 *  3. 1 <= x <= 9: move forward x units
 *
 * Some of the grid squares are obstacles.
 *
 * The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])
 * If the robot would try to move onto them, the robot stays on the previous grid square instead
 * (but still continues following the rest of the route.)
 * Return the square of the maximum Euclidean distance that the robot will be from the origin.
 *
 * Example 1:
 * Input: commands = [4,-1,3], obstacles = [], Output: 25
 * Explanation: robot will go to (3, 4)
 *
 * Example 2:
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]], Output: 65
 * Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)
 *
 * Note:
 *  1. 0 <= commands.length <= 10000
 *  2. 0 <= obstacles.length <= 10000
 *  3. -30000 <= obstacle[i][0] <= 30000
 *  4. -30000 <= obstacle[i][1] <= 30000
 *  5. The answer is guaranteed to be less than 2 ^ 31.
 *
 * @author Juho Lee
 * @since Oct 27, 2019
 */
public class problem_0136 {

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, dir = 0, max = 0;
        int[] xDir = new int[] {1,0,-1,0};
        int[] yDir = new int[] {0,1,0,-1};
        Map<Integer, Set<Integer>> obs = new HashMap<>();
        for(int[] obstacle : obstacles) {
            obs.putIfAbsent(obstacle[1], new HashSet<>());
            obs.get(obstacle[1]).add(obstacle[0]);
        }
        for(int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if(command > 0) {
                while(command-- > 0) {
                    x += xDir[dir];
                    y += yDir[dir];
                    if(obs.containsKey(x) && obs.get(x).contains(y)) {
                        x -= xDir[dir];
                        y -= yDir[dir];
                        break;
                    }
                }
                max = Math.max(max, x * x + y * y);
            } else if(command == -1) {
                dir = (dir + 1) % 4;
            } else if(command == -2) {
                dir = (dir == 0) ? 3 : dir - 1;
            }
        }
        return max;
    }

}
