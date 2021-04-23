package util;

public class DoubleLinkedList {

    private DoublyNode head;
    private DoublyNode tail;

    public DoubleLinkedList() {
        head = new DoublyNode(-1, -1);
        tail = new DoublyNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(DoublyNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int delete(DoublyNode node) {
        int key = node.key;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return key;
    }

    public int deleteLast() {
        if (head.next == tail) return -1;
        return delete(tail.prev);
    }

    public static class DoublyNode extends Node {
        DoublyNode prev;
        DoublyNode next;
        int key;
        public DoublyNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
