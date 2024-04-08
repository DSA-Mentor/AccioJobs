import java.util.ArrayList;

public class Main {
    static class MyStack {
        ArrayList<Integer> list;
        int size;

        MyStack() {
            list = new ArrayList<>();
            size = 0;
        }

        // TC: O(1)
        // add 
        void push(int ele) {
            list.add(ele);
            size++;
        }

        // TC: O(1)
        // remove
        int pop() {
            if (size == 0) {
                System.err.println("Stack underflow");
                return -1;
            } else {
                int pos = size - 1;
                size--;
                return list.remove(pos);
            }
        }

        // TC: O(1)
        // topmost
        int peek() {
            if (size == 0) {
                System.err.println("Stack underflow");
                return -1;
            } else {
                int pos = size - 1;
                return list.get(pos);
            }
        }

        // TC: O(1)
        // size
        int size() {
            return size;
        }
    }
    
    public static void main(String[] args) {
        MyStack st = new MyStack();

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

        System.out.println("remove topmost: " + st.pop());
    }    
}
