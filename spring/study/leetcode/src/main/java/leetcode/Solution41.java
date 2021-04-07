package leetcode;

import java.util.PriorityQueue;

/**
 * 41. 缺失的第一个正数
 * @author dsx
 */
public class Solution41 {
//    public int firstMissingPositive(int[] nums) {
//        int num = 1;
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= num) {
//                priorityQueue.add(nums[i]);
//                while (priorityQueue.peek() != null && priorityQueue.peek() <= num) {
//                    Integer poll = priorityQueue.poll();
//                    if (poll == num) {
//                        num++;
//                    }
//                }
//            }
//        }
//
//        return num;
//    }

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            if (nums[i] >= 1 && nums[i] <= length) {
                arr[nums[i] - 1] = nums[i];
            }
        }

        for (int i = 0; i < length; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        return length + 1;
    }
}
