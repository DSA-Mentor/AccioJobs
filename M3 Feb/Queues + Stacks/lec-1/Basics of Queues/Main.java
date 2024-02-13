import java.util.*;

public class Main {
    public static void main(String[] args) {
        // // initialize a queue
        // Queue<Integer> que = new ArrayDeque<>();

        // // Enqueue operation
        // que.add(10);
        // que.add(20);
        // que.add(30);

        // // size
        // System.out.println("size: " + que.size());

        // // front of the queue
        // System.out.println("Front Element: " + que.peek());

        // // Dequeue operation
        // System.out.println("removed Element: " + que.remove());

        // initialize a queue
        Queue<Integer> que = new LinkedList<>();

        // Enqueue operation
        que.offer(10);
        que.add(20);
        que.add(30);

        // size
        System.out.println("size: " + que.size());

        // front of the queue
        System.out.println("Front Element: " + que.peek());

        // Dequeue operation
        System.out.println("removed Element: " + que.poll());
    }
}
