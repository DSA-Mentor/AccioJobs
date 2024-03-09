import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // initialize a stack
        Stack<Integer> st = new Stack<>();

        // add elements to the stack
        st.push(10);
        st.push(20);
        st.push(40);
        st.push(60);

        // size of the stack
        System.out.println("size: " + st.size());

        // View topmost element of the stack
        System.out.println("peek: " + st.peek());

        // remove topmost element of the stack
        System.out.println("pop: " + st.pop());

    }
}