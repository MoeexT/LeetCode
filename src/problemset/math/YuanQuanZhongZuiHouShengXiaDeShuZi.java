package problemset.math;

/**
 * @date: 2020-03-30
 * @time: 20:00:06
 * @author: MoeexT
 * @problem: interview 62
 * @url: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */

public class YuanQuanZhongZuiHouShengXiaDeShuZi {
    /** 
     * @help: https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/comments/317124
     * @time: 7ms 99.88%
     * @mem: 36.5MB 100.00%
     */
    public int lastRemaining(int n, int m) {
        int res = 0;
        for (int i  = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

    public static void main(String[] args) {
        YuanQuanZhongZuiHouShengXiaDeShuZi obj = new YuanQuanZhongZuiHouShengXiaDeShuZi();
        System.out.println(obj.lastRemaining(70866, 116922));
    }
}
