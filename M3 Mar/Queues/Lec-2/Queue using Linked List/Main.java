import java.util.*;

class Node {
    int data;
    Node next;

    Node() {
    }

    Node(int data) {
        this.data = data;
    }
}

class Queue {
    Node head;
    Node tail;
    int size;

    Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // TC: O(1)
    public void push(int value) {
        Node node = new Node(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            // addLast
            this.tail.next = node;
            this.tail = node;
        }
        this.size++;
    }

    // TC: O(1)
    public int pop() {
        if (this.head == null) {
            return -1;
        } else if (this.head == this.tail) {
            int removedValue = this.head.data;
            this.head = null;
            this.tail = null;
            this.size--;
            return removedValue;
        } else {
            // removeFirst
            int removedValue = this.head.data;
            Node temp = this.head.next;
            this.head.next = null;
            this.head = temp;
            this.size--;
            return removedValue;
        }
    }

    // TC: O(1)
    public int front() {
        if (this.head == null) {
            return -1;
        } else {
            return this.head.data;
        }
    }

    // TC: O(1)
    public int getSize() {
        return this.size;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                int x = sc.nextInt();
                q.push(x);
            } else if (op == 2) {
                System.out.println(q.pop());
            } else if (op == 3)
                System.out.println(q.front());
            else if (op == 4)
                System.out.println(q.getSize());
        }
    }
}