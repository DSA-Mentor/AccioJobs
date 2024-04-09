import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    // TC: O(N), SC: O(N)
    public boolean ExtraBrackets(String exp) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch != ')') {
                // char is an opening bracket or an experession
                st.push(ch);
            } else {
                // char is a closing bracket
                if (st.peek() == '(') {
                    // no experession in between
                    // Extra bracket pair
                    return true;
                } else {
                    // remove expression from the stack
                    while (st.peek() != '(') {
                        st.pop();
                    }

                    // remove corresponding opening bracket pair
                    st.pop();
                }
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        Solution Obj = new Solution();
        if (Obj.ExtraBrackets(exp))
            System.out.println("true");
        else
            System.out.println("false");
    }
}