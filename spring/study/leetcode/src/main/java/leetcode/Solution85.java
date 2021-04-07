package leetcode;

/**
 * 85. 最大矩形
 * @author dsx
 */
public class Solution85 {
    private int res = 0;

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                }else {
                    heights[j] = 0;
                }
            }
            largestRectangleArea(heights, 0, cols - 1);
        }

        return res;
    }


    private void largestRectangleArea(int[] heights, int left, int right) {
        if (left > right) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int mid = left;
        for (int i = left; i <= right; i++) {
            if (min > heights[i]) {
                min = heights[i];
                mid = i;
            }
            if (max < heights[i]) {
                max = heights[i];
            }
        }
        int rectangleArea = (right - left + 1) * min;
        if (res < rectangleArea) {
            res = rectangleArea;
        }
        if (max == min) {
            return;
        }

        largestRectangleArea(heights, left, mid - 1);
        largestRectangleArea(heights, mid + 1, right);
    }
}
