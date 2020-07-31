package problemset.array;

import java.util.Arrays;

/**
 * @date: 2020-03-22
 * @time: 13:56:00
 * @author: MoeexT Problem: 945 
 * url: https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 */

public class MinimumIncrementToMakeArrayUnique {
    
    public int minIncrementForUnique(final int[] A) {
    /** 
    * @time: 1536ms 5.00%
    * @mem: 45.8MB 92.16%
    */
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            /* while (A[i-1] >= A[i]) {
                A[i] += 1;
                count ++;
            } */
            /** 
            * @from: https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/comments/299868
            * @time: 16ms 77.81%
            * @mem: 46.6MB 82.35%
            */
            if (A[i-1] >= A[i]) {
                count += A[i-1] - A[i] + 1;
                A[i] = A[i-1] + 1;
            }
        }
        return count;
    }

    public static void main(final String[] args) {
        final MinimumIncrementToMakeArrayUnique obj = new MinimumIncrementToMakeArrayUnique();
        System.out.println(obj.minIncrementForUnique(new int[] { 3,2,1,2,1,7 }));
    }
}
