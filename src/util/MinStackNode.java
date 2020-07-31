package util;

public class MinStackNode {
    public int val;
    public int min;

    public MinStackNode(int val) {
        this(val, val);
    }

    public MinStackNode(int val, int min) {
        this.val = val;
        this.min = min;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", min=" + min +
                '}';
    }
}
