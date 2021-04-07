package leetcode;

/**
 * 88. 合并两个有序数组
 * @author dsx
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        --m;
        --n;
        while(index >= 0)
        {
            if (m < 0){
                nums1[index] = nums2[n];
                --n;
            }else if (n < 0)
            {
                nums1[index] = nums1[m];
                --m;
            }else if(nums1[m] >= nums2[n])
            {
                nums1[index] = nums1[m];
                --m;
            }else
            {
                nums1[index] = nums2[n];
                --n;
            }

            --index;
        }
    }
}
