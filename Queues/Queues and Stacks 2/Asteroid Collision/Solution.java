

// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // code here
        Stack<Integer> st = new Stack<>();
        
        for (int asteroid : asteroids) {
            if (asteroid >= 0) {
                st.push(asteroid);
            } else {
                if (st.size() == 0) {
                    st.push(asteroid);
                } else {
                    while (st.size() > 0 && st.peek() >= 0 && st.peek() < Math.abs(asteroid)) {
                        st.pop();
                    }
                    
                    if (st.size() > 0 && st.peek() == Math.abs(asteroid)) {
                        st.pop();
                    } else if (st.size() > 0 && st.peek() > Math.abs(asteroid)) {
                        
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