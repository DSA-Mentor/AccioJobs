import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int q = sc.nextInt();
            Solution g = new Solution();
            while (q > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    System.out.print(g.pop() + " ");
                } else if (qt == 3) {
                    System.out.print(g.getMin() + " ");
                }

                q--;
            }
            System.out.println();
            T--;
        }
        sc.close();

    }
}

class Pair {
    int ele;
    int minVal;

    Pair(int e, int m) {
        ele = e;
        minVal = m;
    }
}

class Solution {
    Stack<Pair> st;

    Solution() {
        st = new Stack();
    }

    void push(int x) {
        if (st.size() == 0) {
            st.push(new Pair(x, x));
        } else {
            st.push(new Pair(x, Math.min(st.peek().minVal, x)));
        }
    }

    int pop() {
        if (st.size() == 0) {
            return -1;
        } else {
            return st.pop().ele;
        }
    }

    int getMin() {
        if (st.size() == 0) {
            return -1;
        } else {
            return st.peek().minVal;
        }
    }
}
