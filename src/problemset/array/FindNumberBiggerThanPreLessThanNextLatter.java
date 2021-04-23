package problemset.array;

import java.util.*;

public class FindNumberBiggerThanPreLessThanNextLatter {
    public List<Integer> boolArrayFind(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return res;
        int len = nums.length;
        int min = nums[0], max = nums[len - 1];
        boolean[] bls = new boolean[len];
        Arrays.fill(bls, true);

        for (int i = 0; i < len; i++) {
            bls[i] &= nums[i] >= min;
            bls[len - i - 1] &= nums[len - i - 1] <= max;
            min = Math.max(min, nums[i]);
            max = Math.min(max, nums[len - i - 1]);
        }
        for (int i = 0; i < len; i++) {
            if (bls[i]) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    public List<Integer> stackFind(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        if (nums == null || nums.length == 0) {
            return stack;
        }
        int max = nums[0], len = nums.length;

        for (int num : nums) {
            while (!stack.isEmpty() && num <= stack.peek()) stack.pop();

            if (num > max) stack.push(num);
            max = Math.max(max, num);
        }

        return stack;
    }

    public static void main(String[] args) {
        FindNumberBiggerThanPreLessThanNextLatter obj = new FindNumberBiggerThanPreLessThanNextLatter();
        int[] nums = new int[]{};
        System.out.println(obj.boolArrayFind(nums));
        System.out.println(obj.stackFind(nums));
    }
}
