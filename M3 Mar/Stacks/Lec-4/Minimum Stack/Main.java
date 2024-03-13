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

class Solution {
    int minEle;
    Stack<Integer> st;

    Solution() {
        st = new Stack<Integer>();
    }

    void push(int x) {
        if (st.size() == 0) {
            st.push(x);
            minEle = x;
        } else {
            if (x < minEle) {
                int newVal = x - minEle;
                minEle = x;
                st.push(newVal);
            } else {
                st.push(x);
            }
        }
    }

    int pop() {
        if (st.size() == 0) {
            return -1;
        } else if (st.size() == 1) {
            minEle = 0;
            return st.pop();
        } else {
            if (st.peek() < minEle) {
                int poppedValue = minEle;
                int prevMin = minEle - st.peek();
                minEle = prevMin;
                st.pop();
                return poppedValue;
            } else {
                return st.pop();
            }
        }
    }

    int getMin() {
        if (st.size() == 0) {
            return -1;
        } else {
            return minEle;
        }
    }
}
