package problemset.dp;

/*
 * @date_time: 2020-04-06 21:37
 * @author: MoeexT
 * @problem: 121
 * @url: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */

public class BestTimeToBuyAndSellStock {
    /*
     * @help: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/comments/73905
     * @time: 1ms 99.11%
     * @mem: 39.3MB 5.20%
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int min = prices[0];
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }

        return max;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock solution = new BestTimeToBuyAndSellStock();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
