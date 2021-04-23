package interview;

import java.util.*;

class Node {
    Node left;
    Node mid;
    Node right;
    char val;

    Node(char val) {
        this.val = val;
    }
}

public class Test {

    private static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    private static int[] randomNums(int start, int len, int k) {
        int[] nums = new int[len];
        Random random = new Random();

        for (int i = 0; i < len; i++) {
            nums[i] = random.nextInt(k << 1) - k + i + start;
        }
        return nums;
    }

    // 冒泡排序
    public static void bubbleSort(int[] nums, int k) {
        if (nums == null || nums.length < 2) return;
        boolean flag;
        for (int i = 1; i <= k; i++) {
            flag = false;
            for (int j = i; j < nums.length; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        System.out.println("Bubble Sort:\t" + Arrays.toString(nums));
    }

    // 插入排序
    public static void insertSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            int p = i;
            int num = nums[i];
            while (p > 0 && num < nums[p - 1]) {
                nums[p] = nums[--p];
            }
            nums[p] = num;
        }
        System.out.println("Insert Sort:\t" + Arrays.toString(nums));
    }

    // 堆排序
    public static void heapSort(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int pointer = 0;
        for (int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if (heap.size() > k) {
                nums[pointer++] = heap.poll();
            }
        }
        while (heap.size() > 0) nums[pointer++] = heap.poll();
        System.out.println("Heap Sort:\t\t" + Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int k) {
        int i;
        for (i = k / 2; i < nums.length; i += k) {
            if (i + k - 1 < nums.length) {
                quick_sort(nums, i, i + k - 1);
            }
        }
        for (i = 0; i < nums.length; i += k) {
            if (i + k - 1 < nums.length)
                quick_sort(nums, i, i + k - 1);
        }
        quick_sort(nums, i, nums.length - 1);
        System.out.println("Quick Sort:\t\t" + Arrays.toString(nums));
    }

    private static void quick_sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = quick_pass(nums, left, right);
            quick_sort(nums, left, mid - 1);
            quick_sort(nums, mid + 1, right);
        }
    }

    private static int quick_pass(int[] nums, int left, int right) {
        int flag = nums[left];
        int l = left + 1, r = right;

        while (l < r) {
            while (l < r && nums[l] <= flag) l++;
            while (l < r && nums[r] >= flag) r--;
            if (l < r) swap(nums, l++, r--);
        }
        if (l == r && nums[r] > flag) r--;
        swap(nums, left, r);
        return r;
    }


    public static void main(String[] args) {
        /* trident tree
        Node root = new Node('A');
        root.left = new Node('B');
        root.left.left = new Node('D');
        root.left.mid = new Node('E');
        root.left.right = new Node('F');
        root.mid = new Node('C');
        root.mid.left = new Node('G');
        root.mid.mid = new Node('H');
        root.mid.right = new Node('G');
        root.right = new Node('B');
        root.right.left = new Node('F');
        root.right.mid = new Node('E');
        root.right.right = new Node('D');
        System.out.println(new Test().isMirror(root));*/
        int k = 8;
        int[] nums = new int[]{1, -3, 3, -4, 6, 10, 9, 0, 0, 15, 8, 5, 12, 7, 21, 16, 22, 24, 20, 25, 22, 16, 22, 22, 24, 31, 22, 25, 20, 36, 26, 25};  // randomNums(0, 32, k)
        System.out.println("Original Array:\t" + Arrays.toString(nums));
//        bubbleSort(nums.clone(), k);
//        insertSort(nums.clone());
//        heapSort(nums.clone(), k);
        quickSort(nums.clone(), k);
//        int[] tn = nums.clone();
//        quick_sort(tn, 0, tn.length - 1);
//        System.out.println("Quick-Sort:\t\t" + Arrays.toString(tn));
        Arrays.sort(nums);
        System.out.println("Java Sort:\t\t" + Arrays.toString(nums));

    }
}
