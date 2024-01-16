import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public int[] asteroidCollision(int[] asteroids) {
        // Stack: asteroids from known universe
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            // if asteroid is moving toward right, no one from known universe can attack me
            /**
                known universe.     unknown univers
                      o->                 o->
                    <-o                   o->
             */
            // hence no collision, insert in known universe
            if (asteroid > 0) {
                st.push(asteroid);
            } 
            // asteroid is moving towards left
            else {
                /**
                    known universe.     unknown univers
                      o->                    <-o
                    <-o                      <-o
                 */

                // lets try to eleminate all the smaller asteroids than me from known universe moving towards right
                while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    // I can destroy them
                    st.pop();
                }

                // if topmost asteroid is moving towards left
                if (st.size() > 0 && st.peek() < 0) {
                    st.push(asteroid);
                } 
                // if topmost asteroid is moving towards right and is equal to me
                else if (st.size() > 0 && st.peek() > 0 && st.peek() == Math.abs(asteroid)){
                    st.pop();
                }
                // if topmost asteroid is moving towards right and is greater to me
                else if (st.size() > 0 && st.peek() > 0 && st.peek() > Math.abs(asteroid)) {
                    // I'll get destroyed
                }
                // known universe is empty
                else {
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