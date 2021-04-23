package structure.heap;

import com.sun.prism.impl.Disposer;

import java.util.*;

/**
 * 固定体积的小顶堆
 * @param <E>
 */
public class FrozenHeap<E> {

    private Object[] data;
    private int pointer;
    private int size;
    private final Comparator<E> comparator;

    /**
     * 初始化一个固定大小的堆
     *
     * @param capacity 容量
     */
    public FrozenHeap(int capacity, Comparator<E> comparator) {
        this.data = new Object[capacity + 2];
        this.comparator = comparator;
        this.pointer = 0;
        this.size = 0;
    }

    /**
     * 入堆
     * @param e 元素
     */
    @SuppressWarnings("unchecked")
    public void insert(E e) {
        this.size++;
        this.data[++this.pointer] = e;
        int idx = pointer;

        while (idx >= 2) {
            if (comparator.compare((E)data[idx >> 1], (E)data[idx]) > 0) {
                swap(idx >> 1, idx);
            }
            idx >>= 1;
        }
        if (pointer == data.length - 1) {
            pop();
        }
//        System.out.println(Arrays.toString(data));
    }

    /**
     * 出堆
     * @return 堆顶元素
     */
    @SuppressWarnings("unchecked")
    public E pop() {
        E heap = (E) this.data[1];
        data[1] = data[pointer];
        data[pointer--] = null;
        int idx = 1;

        while (idx < pointer) {
            int left = idx << 1, right = (idx << 1) + 1;
            if (right <= pointer) {
                if (comparator.compare((E) data[left], (E) data[right]) >= 0) {
                    swap(idx, right);
                    idx = right;
                } else {
                    swap(idx, left);
                    idx = left;
                }
            } else if (left == pointer) {
                swap(idx, left);
                break;
            } else {
                break;
            }
        }
        this.size--;
//        System.out.println(Arrays.toString(data));
        return heap;
    }

    /**
     * 交换堆中的两元素
     * @param p 下标
     * @param q 下标
     */
    @SuppressWarnings("unchecked")
    private void swap(int p, int q) {
//        if (p > pointer || q > pointer || p < 1 || q < 1) return;
        E tmp = (E)data[p];
        data[p] = data[q];
        data[q] = tmp;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        return "FrozenHeap:"+Arrays.toString(data);
    }

    private void setData(E[] data) {
        this.data = data;
    }

    public static void main(String[] args) {
        FrozenHeap<Integer> heap = new FrozenHeap<>(128, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 500; i >= 0; --i) {
            heap.insert(i);
        }
        System.out.println(heap);
        List<Integer> list = new LinkedList<>();
        while (heap.size() > 0) {
            list.add(0, heap.pop());
        }
        System.out.println(list);
    }
}
