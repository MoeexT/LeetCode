package problemset.array;

/*
 * @date_time: 2020-04-27 11:00
 * @author: MoeexT
 * @problem: 33
 * @url: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */

public class SearchInRotatedSortedArray {
    /*
     * @help: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/comments/114623
     * @time: 0ms 100%
     * @mem: 39.6MB 17.74%
     */
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int MID = nums[mid];

            if (MID == target) return mid;
            if (MID >= nums[low]) {
                if (target >= nums[low] && target < MID)
                    high = mid - 1;
//                    return binarySearch(nums, low, mid - 1, target);
                else low = mid + 1;
            } else {
                if (target > MID && target <= nums[high])
                    low = mid + 1;
//                    return binarySearch(nums, mid + 1, high, target);
                else high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;

        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solution = new SearchInRotatedSortedArray();
        System.out.println(solution.search(new int[]{3,1}, 1));
    }
}

