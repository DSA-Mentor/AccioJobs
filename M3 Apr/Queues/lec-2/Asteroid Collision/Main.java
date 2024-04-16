import java.util.*;

public class Main {
    // TC: O(N), SC: O(N)
    public static List<Integer> asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];

            if (asteroid > 0) {
                st.push(asteroid);
            } else {
                while (st.size() > 0 && st.peek() > 0 && st.peek() < Math.abs(asteroid)) {
                    st.pop();
                }

                if (st.size() > 0 && st.peek() > 0 && st.peek() > Math.abs(asteroid)) {
                    // nothing will be added
                    continue;
                } else if (st.size() > 0 && st.peek() > 0 && st.peek() == Math.abs(asteroid)) {
                    st.pop();
                } else {
                    // no one in stack or all asteroids are moving towards left
                    st.push(asteroid);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (st.size() != 0) {
            ans.add(st.pop());
        }

        Collections.reverse(ans);

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] asteroids = new int[n];

        for (int i = 0; i < n; i++) {
            asteroids[i] = scanner.nextInt();
        }

        List<Integer> ans = asteroidCollision(asteroids);

        if (ans.size() == 0) {
            System.out.print(-1);
        } else {
            for (int asteroid : ans) {
                System.out.print(asteroid + " ");
            }
        }
    }
}
