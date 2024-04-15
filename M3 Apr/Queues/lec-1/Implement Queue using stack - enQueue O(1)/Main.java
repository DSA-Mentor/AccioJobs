import java.util.*;

class StackQueue {
    // write your code here
    Stack<Integer> A;
    Stack<Integer> B;

    StackQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }

    // Enqueue: O(1)
    void Push(int a) {
        A.push(a);
    }

    // Dequeue: O(N)
    int Pop() {
        if (A.size() == 0) {
            return -1;
        }

        while (A.size() != 1) {
            B.push(A.pop());
        }

        int ele = A.pop();

        while (B.size() != 0) {
            A.push(B.pop());
        }

        return ele;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackQueue s = new StackQueue();
        int q = scanner.nextInt();

        while (q-- > 0) {
            int queryType = scanner.nextInt();
            if (queryType == 1) {
                int a = scanner.nextInt();
                s.Push(a);
            } else if (queryType == 2) {
                System.out.print(s.Pop() + " ");
            }
        }
    }
}
