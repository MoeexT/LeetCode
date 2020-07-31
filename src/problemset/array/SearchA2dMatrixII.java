package problemset.array;

/*
 * @date_time: 2020-04-07 13:36
 * @author: MoeexT
 * @problem: 240
 * @url: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */

public class SearchA2dMatrixII {
    /*
     * 二分法
     * 剑指offer同样的题目
     * @url: https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/submissions/
     * @help: https://leetcode-cn.com/problems/search-a-2d-matrix-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-4/
     * @time: 0ms 100.00%
     * @mem: 45.9MB 100.00%
     */


    /*
     * @time: 8 ms 50.81%
     * @mem: 45.2MB 25.00%
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        for (int[] ints : matrix) {
            if (ints[0] > target) {
                return false;
            }
            if (ints[ints.length - 1] < target) {
                continue;
            }
            if (binarySearch(ints, target) != -1) {
                return true;
            }
        }

        return false;
    }

    /*
     * @time: 7 ms 88.31%
     * @mem: 45.5MB 17.34%
     */
    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int n = nums[mid];
            if (n == target) {
                return mid;
            } else if (n < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

