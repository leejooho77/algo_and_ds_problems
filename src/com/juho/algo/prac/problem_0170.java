package com.juho.algo.prac;

/**
 * Given two rectangles, find the area of intersection.
 *
 * @author Juho Lee
 * @since Nov 16, 2019
 */
public class problem_0170 {

    public static class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;
        public Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public int intersectionArea(Rectangle rec1, Rectangle rec2) {
        int x1 = Math.max(rec1.x1, rec2.x1);
        int x2 = Math.min(rec1.x2, rec2.x2);
        int y1 = Math.max(rec1.y1, rec2.y1);
        int y2 = Math.min(rec1.y2, rec2.y2);
        if((x2 - x1) < 0 || (y2 - y1) < 0) return 0;
        return (x2 - x1) * (y2 - y1);
    }

}