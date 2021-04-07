package leetcode;

/**
 * 42. 接雨水
 * @author dsx
 */
public class Solution42 {
    public int trap(int[] height) {
        if (height== null||height.length == 0) return 0;
        int[] nums = new int[height.length];
        int sum = 0;
        int maxIndex = 0;
        int h = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
            if (h > height[i]) {
                sum += h - height[i];
            }else {
                h = height[i];
            }
            nums[i] = sum;
        }
        sum = nums[maxIndex];
        h = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (h > height[i]) {
                sum += h - height[i];
            }else {
                h = height[i];
            }
        }
        return sum;
    }

//    public int trap(int[] height) {
//        if (height== null||height.length == 0) return 0;
//        int sum = 0;
//        int maxIndex = 0;
//        for (int i = 0; i < height.length; i++) {
//            if (height[maxIndex] < height[i]) {
//                maxIndex = i;
//            }
//        }
//        int h = height[0];
//        for (int i = 1; i < maxIndex; i++) {
//            if (h > height[i]) {
//                sum += h - height[i];
//            }else {
//                h = height[i];
//            }
//        }
//        h = height[height.length - 1];
//        for (int i = height.length - 2; i > maxIndex; i--) {
//            if (h > height[i]) {
//                sum += h - height[i];
//            }else {
//                h = height[i];
//            }
//        }
//
//        return sum;
//    }


//    public int trap(int[] height) {
//        if (height== null||height.length == 0) return 0;
//        int sum = 0;
//        int index = 0;
//        int h = height[index];
//        while (index < height.length) {
//            int i = index + 1;
//            for (; i < height.length; i++) {
//                if (h  <= height[i]) {
//                    sum += trap(height, index + 1, i - 1, h);
//                    index = i;
//                    h = height[i];
//                    break;
//                }
//            }
//            if (i == height.length) {
//                if (h > 1) {
//                    h--;
//                }else {
//                    index++;
//                }
//            }
//        }
//        return sum;
//    }
//
//    private int trap(int[] height, int l, int r, int h) {
//        int sum = 0;
//        while (l < r) {
//            sum += h - height[l];
//            sum += h - height[r];
//            l++;
//            r--;
//        }
//        if (l == r) {
//            sum += h - height[l];
//        }
//
//        return sum;
//    }
}
