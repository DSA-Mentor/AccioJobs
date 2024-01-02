import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String exp = br.readLine();
    Solution ob =new Solution();
    ob.evaluate(exp);
  }
}

class Solution {
    // more the return value, heigher the precedence
    public int precedence(char o) {
        if (o == '/' || o == '*') return 2;
        else if (o == '+' || o == '-') return 1;
        else return 0;
    }

    public int eval(int v1, char o, int v2) {
        if (o == '/') return v1 / v2;
        else if (o == '*') return v1 * v2;
        else if (o == '+') return v1 + v2;
        else return v1 - v2;
    }

    public void solve(String exp) {
        // stack 1: operands -> numbers
        Stack<Integer> opd = new Stack<>();

        // stack 2: operators -> char
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            
            if (ch == '(') {
                opr.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                opd.push(ch - '0');
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    int v2 = opd.pop();
                    int v1 = opd.pop();

                    char o = opr.pop();

                    int ans = eval(v1, o, v2);

                    opd.push(ans);
                }

                // remove the '('
                opr.pop();
            } else {
                while (opr.size() > 0 && precedence(ch) <= precedence(opr.peek())) {
                    int v2 = opd.pop();
                    int v1 = opd.pop();

                    char o = opr.pop();

                    int ans = eval(v1, o, v2);

                    opd.push(ans);
                }

                opr.push(ch);
            }
        }

        while (opr.size() != 0) {
            int v2 = opd.pop();
            int v1 = opd.pop();

            char o = opr.pop();

            int ans = eval(v1, o, v2);

            opd.push(ans);
        }

        System.out.println(opd.peek());
    }

    public void convert(String exp) {
        // postfix
        Stack<String> post = new Stack<>();

        // prefix
        Stack<String> pre = new Stack<>();

        // stack: operators -> char
        Stack<Character> opr = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            
            if (ch == '(') {
                opr.push(ch);
            } else if (ch >= '0' && ch <= '9') {
                // opd.push(ch - '0');
                post.push(ch + "");
                pre.push(ch + "");
            } else if (ch == ')') {
                while (opr.peek() != '(') {
                    char o = opr.pop();

                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postAns = postV1 + postV2 + o;
                    post.push(postAns);

                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preAns = o + preV1 + preV2;
                    pre.push(preAns);
                }

                // remove the '('
                opr.pop();
            } else {
                while (opr.size() > 0 && precedence(ch) <= precedence(opr.peek())) {
                    char o = opr.pop();

                    String postV2 = post.pop();
                    String postV1 = post.pop();
                    String postAns = postV1 + postV2 + o;
                    post.push(postAns);

                    String preV2 = pre.pop();
                    String preV1 = pre.pop();
                    String preAns = o + preV1 + preV2;
                    pre.push(preAns);
                }

                opr.push(ch);
            }
        }

        while (opr.size() != 0) {
            char o = opr.pop();

            String postV2 = post.pop();
            String postV1 = post.pop();
            String postAns = postV1 + postV2 + o;
            post.push(postAns);

            String preV2 = pre.pop();
            String preV1 = pre.pop();
            String preAns = o + preV1 + preV2;
            pre.push(preAns);
        }

        System.out.println(post.peek());
        System.out.println(pre.peek());
    }
    
    public void evaluate(String exp) {
        // Write code here

        solve(exp);

        convert(exp);
    }
}               