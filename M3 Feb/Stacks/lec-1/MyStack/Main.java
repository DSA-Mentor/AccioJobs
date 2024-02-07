import java.util.ArrayList;

public class Main {

    static class MyStack {
        ArrayList<Integer> stack;

        MyStack() {
            stack = new ArrayList<>();
        }
        
        // TC: O(1)
        void push(int ele) {
            stack.add(ele);
        } 
        
        // TC: O(1)
        int pop() {
            if (stack.size() != 0) {
                int ele = stack.remove(stack.size() - 1);
                return ele;
            } else {
                System.out.println("stack is empty");
                return -1;
            }
        }

        // TC: O(1)
        int peek() {
            if (stack.size() != 0) {
                return stack.get(stack.size() - 1);
            } else {
                System.out.println("stack is empty");
                return -1;
            }
        }

        // TC: O(1)
        int size() {
            return stack.size();
        }
    }

    public static void main(String[] args) {
        MyStack st = new MyStack();
        
        // add some ele
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        // size of the stack
        System.out.println("size: " + st.size());

        // topmost person of the stack
        System.out.println("topmost: " + st.peek());

        // remove from stack
        System.out.println("removed ele: " + st.pop());

        // size of the stack
        System.out.println("size: " + st.size());

        // topmost person of the stack
        System.out.println("topmost: " + st.peek());
    }    
}
