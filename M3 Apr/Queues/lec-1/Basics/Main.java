import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> que = new ArrayDeque<>();

        // add elements to the queue
        que.add(10);
        que.offer(20);
        que.add(30);
        que.add(40);

        // size of the que
        System.out.println("size: " + que.size());

        // front element of the que
        System.out.println("Front element: " + que.peek());

        // remove element form queue
        System.out.println("Removed element: " + que.remove());

        // removing all the elements
        while (que.size() != 0) {
            System.out.println(que.poll());
        }
    }
}
