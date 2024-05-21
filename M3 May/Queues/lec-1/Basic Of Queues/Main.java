import java.util.*;

public class Main {
    public static void main(String[] args) {
        // initialize a Queue
        // Queue<Integer> que = new ArrayDeque<>();
        Queue<Integer> que = new LinkedList<>();

        // Enqueue operations
        que.add(10);
        que.add(20);
        que.add(30);
        que.offer(40);

        // size of the queue
        System.out.println("size: " + que.size());

        // return value of front ele
        System.out.println("front: " + que.peek());

        // size of the queue
        System.out.println("size: " + que.size());

        // Dequeue operations
        System.out.println("removed: " + que.poll());

        // size of the queue
        System.out.println("size: " + que.size());

        while (que.size() != 0) {
            System.out.println("removed: " + que.remove());
        }

        // size of the queue
        System.out.println("size: " + que.size());

        // Dequeue operations
        System.out.println("removed: " + que.remove());
    }
}
