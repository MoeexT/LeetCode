package problemset.binarySearch;

class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
    public int binarySearchInsert(int[]  nums, int target) {
        /*
          烂尾方法
         */
        int left = 0, right = nums.length - 1;
        if (target <= nums[0])
            return 0;
        if (right == 0)
            return nums[0] > target ? 0 : 1;
        if (right == 1) {
            if (target >= nums[0] && target <= nums[1])
                return 1;
            else if (target <= nums[0])
                return 0;
            else
                return 2;
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid - 1] < target && target <= nums[mid]) 
                return mid;
            else if (nums[mid - 1] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return nums.length;
    }

    public static void main(String args[]) {
        SearchInsertPosition solution = new SearchInsertPosition();
        System.out.println(solution.binarySearchInsert(new int[]{1,2,3,4,5,10}, 2));
    }
}