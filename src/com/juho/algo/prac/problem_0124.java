package com.juho.algo.prac;

import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Example 1:
 * Input: points = [[1,3],[-2,2]], K = 1, Output: [[-2,2]]
 * Explanation:
 *  - The distance between (1, 3) and the origin is sqrt(10).
 *  - The distance between (-2, 2) and the origin is sqrt(8).
 *  - Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 *  - We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 * Example 2:
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2, Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 * Note:
 *   - 1 <= K <= points.length <= 10000
 *   - -10000 < points[i][0] < 10000
 *   - -10000 < points[i][1] < 10000
 *
 * @author Juho Lee
 * @since Oct 22, 2019
 */
public class problem_0124 {

    public class Point {
        int x;
        int y;
        int distance;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = getDistance(x, y);
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.distance, a.distance);
        });
        for(int[] point : points) {
            heap.add(new Point(point[0], point[1]));
            if(heap.size() > K)
                heap.remove();
        }
        int[][] result = new int[K][2];
        int i = 0;
        while(!heap.isEmpty()) {
            Point point = heap.remove();
            result[i][0] = point.x;
            result[i++][1] = point.y;
        }
        return result;
    }

    private int getDistance(int x, int y) {
        return x * x + y * y;
    }

}
