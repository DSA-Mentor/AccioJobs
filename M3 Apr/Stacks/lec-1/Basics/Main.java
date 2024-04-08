import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // initialize a stack
        Stack<Integer> st = new Stack<>();

        // TC: O(1)
        // add elements to the top of the stack
        st.push(10);
        st.push(20);
        st.push(15);
        st.push(30);

        // TC: O(1)
        // number of elements in the stack
        System.out.println("size: " + st.size());

        // TC: O(1)
        // topmost element in the stack
        System.out.println("topmost element: " + st.peek());

        // TC: O(1)
        // number of elements in the stack
        System.out.println("size: " + st.size());

        // TC: O(1)
        // remove topmost element of the stack
        System.out.println("remove topmost: " + st.pop());

        // number of elements in the stack
        System.out.println("size: " + st.size());

        // remove all the element of the stack
        while (st.size() > 0) {
            // remove topmost element of the stack
            System.out.println("remove topmost: " + st.pop());
        }

        // number of elements in the stack
        System.out.println("size: " + st.size());
    }
}
