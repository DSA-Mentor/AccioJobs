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
	public class Pair {
		int val;
		int minVal;

		Pair(int v, int mv) {
			val = v;
			minVal = mv;
		}
	}

	Stack<Pair> s;

	Solution() {
		s = new Stack<>();
	}

	void push(int x) {
		// Write Code here
		if (s.size() == 0) {
			s.push(new Pair(x, x));
		} else {
			int t = Math.min(s.peek().minVal, x);
			s.push(new Pair(x, t));
		}
	}

	int pop() {
		// Write Code here
		if (s.size() == 0) {
			return -1;
		}

		return s.pop().val;
	}

	int getMin() {
		// Write Code here
		if (s.size() == 0) {
			return -1;
		}

		return s.peek().minVal;
	}
}
