import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // Stack: known universe
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            if (asteroid > 0) {
                /**
                 * <----O ||
                 * O----> || O---->
                 */
                st.push(asteroid);
            } else {
                /**
                 * <----O ||
                 * O----> || <----O
                 */

                while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    st.pop();
                }

                if (st.size() == 0) {
                    st.push(asteroid);
                } else {
                    if (st.peek() > 0 && st.peek() > Math.abs(asteroid)) {
                        // you will get destroyed
                    } else if (st.peek() > 0 && st.peek() == Math.abs(asteroid)) {
                        // both will get destroyed
                        st.pop();
                    } else {
                        st.push(asteroid);
                    }
                }
            }
        }

        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}