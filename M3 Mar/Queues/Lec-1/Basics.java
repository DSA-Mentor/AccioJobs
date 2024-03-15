import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Basics {
    public static void main(String[] args) {
        // initialize a queue approach 1
        // Queue<Integer> que = new ArrayDeque<>();

        // initialize a queue approach 2
        Queue<Integer> que = new LinkedList<>();

        // add elements 
        que.add(10);
        que.add(20);
        que.add(30);
        que.offer(40);
        que.offer(50);
        que.offer(60);

        // size of the queue
        System.out.println("size: " + que.size());

        // see front ele of the queue
        System.out.println("front: " + que.peek());

        // remove ele from queue
        System.out.println("removed: " + que.remove());
        System.out.println("removed: " + que.poll());
    }    
}
