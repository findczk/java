package leetcode;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author dsx
 */
public class Solution84 {


    //超时
//    public int largestRectangleArea(int[] heights) {
//        int res = 0;
//        for (int i = 0; i < heights.length; i++) {
//            //向左找比自己小的
//            int left = i - 1;
//            while (left >= 0 && heights[left] >= heights[i]) {
//                left--;
//            }
//            //向右找比自己小的
//            int right = i + 1;
//            while (right < heights.length && heights[right] >= heights[i]) {
//                right++;
//            }
//
//            int rectangleArea = (right - left - 1) * heights[i];
//            if (res < rectangleArea) {
//                res = rectangleArea;
//            }
//        }
//        return res;
//    }


    private int res = 0;

    public int largestRectangleArea(int[] heights) {
//        int[] indexs = new int[heights.length];
//        for (int i = 0; i < heights.length; i++) {
//
//        }

        largestRectangleArea(heights, 0, heights.length - 1);
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

//    private int res = 0;
//
//    public int largestRectangleArea(int[] heights) {
//        largestRectangleArea(heights, 0, heights.length - 1);
//        return res;
//    }
//
//    private void largestRectangleArea(int[] heights, int left, int right) {
//        if (left > right) {
//            return;
//        }
//        int max = Integer.MIN_VALUE;
//        int min = Integer.MAX_VALUE;
//        int mid = left;
//        for (int i = left; i <= right; i++) {
//            if (min > heights[i]) {
//                min = heights[i];
//                mid = i;
//            }
//            if (max < heights[i]) {
//                max = heights[i];
//            }
//        }
//        int rectangleArea = (right - left + 1) * min;
//        if (res < rectangleArea) {
//            res = rectangleArea;
//        }
//        if (max == min) {
//            return;
//        }
//
//        largestRectangleArea(heights, left, mid - 1);
//        largestRectangleArea(heights, mid + 1, right);
//    }

}
