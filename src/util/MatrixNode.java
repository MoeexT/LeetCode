package util;

public class MatrixNode {
    public int x, y;

    public MatrixNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MatrixNode() {
        this(-1, -1);
    }


    public static MatrixNode add(MatrixNode node1, MatrixNode node2) {
        int x1 = node1.x, y1 = node1.y, x2 = node2.x, y2 = node2.y;
        assert x1 + y1 == x2 + y2 && Math.abs(x1 - x2) == 1;
        return new MatrixNode(Math.max(x1, x2), Math.max(y1, y2));
    }

}
