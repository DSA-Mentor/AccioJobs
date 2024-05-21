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
    int val;
    int minVal;

    Pair(int val, int minVal) {
        this.val = val;
        this.minVal = minVal;
    }
}

class Solution {
    Stack<Pair> st;

    Solution() {
        st = new Stack<>();
    }

    void push(int x) {
        if (st.size() == 0) {
            st.push(new Pair(x, x));
        } else {
            int minVal = st.peek().minVal;
            minVal = Math.min(minVal, x);
            st.push(new Pair(x, minVal));
        }
    }

    int pop() {
        if (st.size() == 0) {
            return -1;
        } else {
            Pair rpair = st.pop();
            return rpair.val;
        }
    }

    int getMin() {
        if (st.size() == 0) {
            return -1;
        } else {
            Pair rpair = st.peek();
            return rpair.minVal;
        }
    }
}
