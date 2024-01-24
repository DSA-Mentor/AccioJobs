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
		// Write Code here
		if (st.size() == 0) {
			st.push(x);
			minEle = x;
		} else {
			if (x < minEle) {
				int val = x - minEle;
				st.push(val);
				minEle = x;
			} else {
				st.push(x);
			}
		}
	}

	int pop() {
		// Write Code here
		if (st.size() == 0) {
			return -1;
		} else if (st.peek() < minEle) {
			int val = minEle;
			minEle = minEle - st.peek();
			st.pop();
			return val;
		} else {
			return st.pop();
		}
	}

	int getMin() {
		// Write Code here
		if (st.size() > 0) {
			return minEle;
		} else {
			return -1;
		}
	}
}
