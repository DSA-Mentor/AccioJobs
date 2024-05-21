import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Queue {
    Node head;
    Node tail;
    int size;

    Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    // add last in linked list
    public void push(int value) {
        Node node = new Node(value);

        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // remove first from a linked list
    public int pop() {
        if (head == null) {
            return -1;
        } else if (head == tail) {
            int val = head.data;

            head = tail = null;

            size--;
            return val;
        } else {
            int val = head.data;

            Node temp = head.next;
            head.next = null;

            head = temp;

            size--;
            return val;
        }
    }

    public int front() {
        if (head == null) {
            return -1;
        } else {
            return head.data;
        }
    }

    public int getSize() {
        return size;
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