package problemset.array;

/*
 * @date_time: 2021-03-17 23:18
 * @author: MoeexT
 * @problem: 56
 * @url: https://leetcode-cn.com/problems/merge-intervals
 */

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    /*
     * 随便看看就懂了
     * @time: 12ms 8.48%
     * @mem: 41.2MB 53.93%
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        LinkedList<int[]> list = new LinkedList<>();
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        list.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= list.peekLast()[1]) {
                list.peekLast()[1] = Math.max(intervals[i][1], list.peekLast()[1]);
            } else {
                list.offer(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        MergeIntervals solution = new MergeIntervals();
        for (int[] interval : solution.merge(new int[][]{
                {1, 3},
                {2, 3},
                {8, 10},
                {15, 18}
        })) {
            System.out.println(Arrays.toString(interval));
        }
    }
}

