package problemset.sort;

/**
 * @date: 2020-03-31
 * @time: 00:05:31
 * @author: MoeexT
 * @problem: 912
 * @url: https://leetcode-cn.com/problems/sort-an-array/
 */

public class SortAnArray {
    /** 
     * @help: 
     * @time: 5ms 97.89%
     * @mem: 47.9MB 5.34%
     */
    public int[] sortArray(int[] nums) {
        return quick_sort(nums, 0, nums.length - 1);
    }

    public int[] quick_sort(int[] nums, int low, int high) {

        if (low < high) {
            int mid = quick_pass(nums, low, high);
            quick_sort(nums, low, mid - 1);
            quick_sort(nums, mid + 1, high);
        }
        return nums;
    }

    public int quick_pass(int[] nums, int low, int high) {

        int flag = nums[low];
        int p = low, q = high + 1;

        while (true) {
            while (++p <= high && nums[p] < flag) ;
            while (--q >= low && nums[q] > flag) ;
            if (p >= q) {
                break;
            }
            nums[p] = nums[q] + (nums[q] = nums[p]) * 0;
        }
        System.out.println(q);
        nums[low] = nums[q];
        nums[q] = flag;

        return q;
    }

    public static void main(String[] args) {
        SortAnArray obj = new SortAnArray();
        System.out.println(obj.sortArray(new int[] { 5, 1, 1, 2, 0, 0 }));
    }
}
