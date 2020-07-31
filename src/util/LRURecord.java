package util;

public class LRURecord {
    int val;
    private int time;

    public LRURecord(int val) {
        this.val = val;
        this.time = 0;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void reset() {
        this.time = 0;
    }

    public void update() {
        this.time++;
    }

    public int getVal() {
        return val;
    }

    public int getTime() {
        return time;
    }
}
