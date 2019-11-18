package com.juho.algo.prac;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 *
 * Example:
 * Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2, Output: 45
 *
 * Note: Assume that the total area is never beyond the maximum possible value of int.
 *
 * @author Juho Lee
 * @since Nov 18, 2019
 */
public class problem_0172 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.min(C, G), x2 = Math.max(A, E);
        int y1 = Math.min(D, H), y2 = Math.max(B, F);
        int areaOfTwoRecs = (C - A) * (D - B) + (G - E) * (H - F);
        int overlappingArea = (x1 - x2) * (y1 - y2);
        // does not overlap
        if(x1 <= x2 || y1 <= y2) {
            return areaOfTwoRecs;
        } else {
            return areaOfTwoRecs - overlappingArea;
        }
    }

}