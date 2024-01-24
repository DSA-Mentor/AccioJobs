import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        // initiliaze a queue
        Queue<Integer> que = new ArrayDeque<>();

        // add elements in the queue
        que.add(10);
        que.add(20);
        que.add(30);
        que.add(40);

        // size of the queue
        System.out.println("size: " + que.size());

        // get head of the queue
        System.out.println("head: " + que.peek());

        // remove people
        System.out.println("remove head: " + que.remove());
    }
}
