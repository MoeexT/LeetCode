package problemset.math;

public class RectangleOverlap {
    public boolean isSolution(int[] rec1, int[] rec2) {
        /** https://leetcode-cn.com/problems/rectangle-overlap/comments/292063
         * 0ms: 100.00%
         * 37.2MB: 5.49%
         *  */ 
        return !(rec1[0] >= rec2[2] || rec2[0] >= rec1[2] || rec1[1] >= rec2[3] || rec2[1] >= rec1[3]);
    }

    public static void main(String[] args) {
        RectangleOverlap Solution = new RectangleOverlap();
        boolean res = Solution.isSolution(new int[] { 0, 0, 1, 1 }, new int[] { 1, 0, 2, 1 });
        System.out.println(res);
    }
}
