import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        // add at the first position
        dq.addFirst(10);
        dq.addFirst(20);
        dq.addFirst(30);
        dq.addFirst(40);

        System.out.println("get Last: " + dq.getLast());

        System.out.println("get First: " + dq.getFirst());

        System.out.println("size: " + dq.size());

        dq.addLast(-10);

        System.out.println("get Last: " + dq.getLast());

        System.out.println("remove First: " + dq.removeFirst());

        while (dq.size() != 0) {
            System.out.println("remove Last: " + dq.removeLast());
        }
    }    
}
