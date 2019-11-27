package com.juho.algo.prac;

import java.util.*;

/**
 * Given a list of points, an interger k, and a point p, find the k closest points to p.
 *
 * @author Juho Lee
 * @since Nov 27, 2019
 */
public class problem_0195 {

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getDistance(Point p) {
            int x = this.x - p.x;
            int y = this.y - p.y;
            return (x * x) + (y * y);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", this.x, this.y);
        }
    }

    public List<Point> closestPoints(List<Point> points, int k, Point p) {
        List<Point> result = new ArrayList<>();
        PriorityQueue<Point> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.getDistance(p), a.getDistance(p)));
        for(Point point : points) {
            heap.add(point);
            if(heap.size() > k)
                heap.remove();
        }
        while(!heap.isEmpty())
            result.add(heap.remove());
        return result;
    }

}