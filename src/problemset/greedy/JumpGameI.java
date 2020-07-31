package problemset.greedy;

/*
 * @date_time: 2020-05-04 11:57
 * @author: MoeexT
 * @problem: 55
 * @url: https://leetcode-cn.com/problems/jump-game/
 */

public class JumpGameI {
    public boolean canJump(int[] nums) {
        int n = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= n)
                n = 1;
            else
                n++;
            if(i == 0 && n > 1)
                return false;
        }

        return true;
    }

    /*
     * @help: https://leetcode-cn.com/problems/jump-game/solution/cong-qian-cong-hou-du-xing-a-by-hamiguaex163com/
     * @time: 1 ms 99.83%
     * @mem: 41.8MB 12.5%
     */
    public boolean jump(int[] nums) {
        int min = nums.length - 1;
        for (int i = nums.length - 2; i > 0; i--) {
            if (i + nums[i] >= min)
                min = i;
        }
        return nums[0] >= min;
    }

    public static void main(String[] args) {
        JumpGameI solution = new JumpGameI();
        System.out.println(solution.jump(new int[] {3,2,1,0,4}));
    }
}

