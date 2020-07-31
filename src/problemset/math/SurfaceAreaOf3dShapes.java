package problemset.math;

/**
 * @date: 2020-03-25
 * @time: 16:32:22
 * @author: MoeexT 
 * @problem: 892 
 * @url: https://leetcode-cn.com/problems/surface-area-of-3d-shapes/
 */

public class SurfaceAreaOf3dShapes {
    /** 
    * @from: https://leetcode-cn.com/problems/surface-area-of-3d-shapes/comments/11371
    * @optimization: https://leetcode-cn.com/problems/surface-area-of-3d-shapes/comments/306345
    * @time: 3ms 98.69%; 6ms 39.10%
    * @mem: 41.3MB 88.24%; 41.3MB 88.24%
    */
    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int n = grid[i][j];
                if (n != 0)
                    res += (n << 2) + 2;
                res -= i > 0 ? Math.min(grid[i - 1][j], n) << 1 : 0;
                res -= j > 0 ? Math.min(grid[i][j - 1], n) << 1 : 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SurfaceAreaOf3dShapes obj = new SurfaceAreaOf3dShapes();
        System.out.println(obj.surfaceArea(new int[][] {{2}}));
    }
}
