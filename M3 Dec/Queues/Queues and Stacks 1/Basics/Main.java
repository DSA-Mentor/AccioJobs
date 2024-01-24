import java.util.*;

public class Main {
    public static void main(String[] args) {
        // // intitialize a queue
        // Queue<Integer> que = new ArrayDeque<>();

        // // Enqueue operation
        // que.add(10);
        // que.add(20);
        // que.add(30);
        // que.add(40);

        // // get size of the que
        // System.out.println("size: " + que.size());

        // // see the first element (front element)
        // System.out.println("Front Element: " + que.peek());

        // // Dequeue operation
        // System.out.println("Removed Element: " + que.remove());
        // System.out.println("Removed Element: " + que.remove());
        // System.out.println("Removed Element: " + que.remove());
        // System.out.println("Removed Element: " + que.remove());

        // intitialize a queue using Linked List interface
        Queue<Integer> que = new LinkedList<>();

        // Enqueue operation
        que.offer(10);
        que.offer(20);
        que.offer(30);
        que.offer(40);

        // get size of the que
        System.out.println("size: " + que.size());

        // see the first element (front element)
        System.out.println("Front Element: " + que.peek());

        // Dequeue operation
        System.out.println("Removed Element: " + que.poll());
        System.out.println("Removed Element: " + que.poll());
        System.out.println("Removed Element: " + que.poll());
    }
}
