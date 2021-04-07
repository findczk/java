package leetcode;

/**
 * 74. 搜索二维矩阵
 * @author dsx
 */
public class Solution74 {
    //先判断在那一层
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;//低
        int high = matrix.length - 1;//高
        int left = 0;//左
        int right = matrix[0].length - 1;//右
        while (low <= high) {
            if (matrix[low][right] < target) {
                low++;
            }else {
                while (left <= right){
                    if (matrix[low][left] < target) {
                        left++;
                    } else return matrix[low][left] <= target;
                    if (matrix[low][right] > target) {
                        right--;
                    } else return matrix[low][right] >= target;
                }
            }
            if (matrix[high][0] > target) {
                high--;
            }else {
                while (left <= right){
                    if (matrix[high][left] < target) {
                        left++;
                    } else return matrix[high][left] <= target;
                    if (matrix[high][right] > target) {
                        right--;
                    } else return matrix[high][right] >= target;
                }
            }
        }

        return false;
    }
}
