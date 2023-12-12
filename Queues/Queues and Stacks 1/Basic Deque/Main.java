import java.util.*;

public class Main {
    public static void main(String[] args) {
        // initialize
        Deque<Integer> dq = new ArrayDeque<>();

        // add front
        dq.addFirst(10);
        dq.addFirst(30);

        // add Last
        dq.addLast(60);

        System.out.println("size: " + dq.size());

        // remove Last
        System.out.println("remove last: " + dq.removeLast());

        // remove first
        System.out.println("remove first: " + dq.removeFirst());

        // remove last
        System.out.println("remove last: " + dq.removeLast());
    }
}
