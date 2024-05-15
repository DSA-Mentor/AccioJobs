import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public boolean ExtraBrackets(String exp) {
        Stack<Character> st = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (ch != ')') {
                st.push(ch);
            } else {
                if (st.peek() == '(') {
                    // no exp in between
                    return true;
                } else {
                    // remove the exp
                    while (st.peek() != '(') {
                        st.pop();
                    }

                    // remove opening bracket
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