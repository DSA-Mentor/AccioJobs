class Solution {
    // TC: O(N), SC: O(N)
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // stable universe
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            if (asteroid > 0) {
                st.push(asteroid);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    st.pop();
                }

                if (st.size() > 0 && st.peek() > 0 && st.peek() == Math.abs(asteroid)) {
                    st.pop();
                } else if (st.size() > 0 && st.peek() > 0 && st.peek() > Math.abs(asteroid)) {
                    continue;
                } else {
                    st.push(asteroid);
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