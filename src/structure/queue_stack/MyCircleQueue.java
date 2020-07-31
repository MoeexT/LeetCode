package structure.queue_stack;

public class MyCircleQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyCircleQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
            tail = 0;
            data[0] = value;
            size ++;
            return true;
        }
        tail = (tail + 1) % data.length;
        data[tail] = value;
        size ++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % data.length;
        size --;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }

    public static void main(String[] args) {
        MyCircleQueue queue = new MyCircleQueue(3);
        System.out.println(queue.enQueue(1));
        System.out.println(queue.enQueue(2));
        System.out.println(queue.enQueue(3));
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());
        System.out.println(queue.isFull());
        System.out.println(queue.deQueue());
        System.out.println(queue.enQueue(4));
        System.out.println(queue.Rear());

        // System.out.println(queue.enQueue(2));
        // System.out.println(queue.Rear());
        // System.out.println(queue.Front());
        // System.out.println(queue.deQueue());
        // System.out.println(queue.Front());
        // System.out.println(queue.deQueue());
        // System.out.println(queue.Front());
        // System.out.println(queue.enQueue(4));
        // System.out.println(queue.enQueue(2));
        // System.out.println(queue.enQueue(2));
        // System.out.println(queue.enQueue(3));
    }
}
