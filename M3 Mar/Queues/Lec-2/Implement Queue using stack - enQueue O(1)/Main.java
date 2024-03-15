import java.io.*;
import java.util.*;

class StackQueue {
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    // Function to push an element in queue by using 2 stacks.
    void Push(int x) {
        // Write your code here
        A.push(x);
    }

    // Function to pop an element from queue by using 2 stacks.
    int Pop() {
        // Write your code here
        if (A.size() == 0) {
            return -1;
        }

        while (A.size() != 1) {
            B.push(A.pop());
        }

        int removedEle = A.pop();

        while (B.size() != 0) {
            A.push(B.pop());
        }

        return removedEle;
    }
}

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        StackQueue s = new StackQueue();
        int q = sc.nextInt();
        ArrayList<Integer> ans = new ArrayList<>();
        while (q > 0) {
            int QueryType = sc.nextInt();
            if (QueryType == 1) {
                int a = sc.nextInt();
                s.Push(a);
            } else if (QueryType == 2)
                ans.add(s.Pop());
            q--;
        }
        for (int x : ans)
            System.out.print(x + " ");
        System.out.println();
    }
}