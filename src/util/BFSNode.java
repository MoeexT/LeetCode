package util;

/**
 * @date: 2020-03-29
 * @time: 16:59:10
 * @author: MoeexT
 * @problem: 1162
 * @url: https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 */

/**
 * 广度搜索矩阵的时候用的节点
 */
public class BFSNode {
    public int step;
    public int x, y;

    public BFSNode(int x, int y, int step) {
        this.x = x;
        this.y = y;
        this.step = step;
    }
}
