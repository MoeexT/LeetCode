package problemset.dfs;

import java.util.Arrays;

/** 
* @date: 2020-03-23
* @time: 12:08:40
* @author: MoeexT
* Problem: 733
* url: https://leetcode-cn.com/problems/flood-fill/
*/

public class FloodFill {
    int color;
    int target;
    public int[][] floodFill (int[][] image, int sr, int sc, int newColor) {
        /** 
        * @time: 1ms 96.54%
        * @time: 0ms 100.00%
        * @mem: 41.1MB 35.60%
        */
        if (image[sr][sc] == newColor)
            return image;
        target = image[sr][sc];
        color = newColor;
        polish(image, sr, sc);
        return  image;
    }

    public void polish(int[][] img, int sr, int sc) {
        if (sr < 0 || sc < 0 || sr >= img.length || sc >= img[0].length || img[sr][sc] != target) {
            return;
        }
        System.out.println(sr+", "+sc);
        img[sr][sc] = color;
        polish(img, sr+1, sc);
        polish(img, sr, sc+1);
        polish(img, sr-1, sc);
        polish(img, sr, sc-1);
    }

    public static void main(String[] args) {
        FloodFill obj = new FloodFill();
        int[][] res = obj.floodFill(new int[][] {
            {0,0,0},
            {0,1,1}}, 1, 1, 1);
        for (int[] is : res) {
            System.out.println(Arrays.toString(is));
        }
    }
}
