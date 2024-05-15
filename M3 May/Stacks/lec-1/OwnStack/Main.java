import java.util.ArrayList;

public class Main {
    
    static class MyStack {
        private ArrayList<Integer> list;

        MyStack() {
            list = new ArrayList<>();
        }

        void push(int ele) {
            list.add(ele);
        }

        int pop() {
            if (list.size() == 0) {
                System.out.println("Stack is empty");
                return -1;
            }

            int ele = list.remove(list.size() - 1);
            return ele;
        }

        int peek() {
            if (list.size() == 0) {
                System.out.println("Stack is empty");
                return -1;
            }

            int ele = list.get(list.size() - 1);
            return ele;
        }

        int size() {
            return list.size();
        }
    }
    
    
    public static void main(String[] args) {
        MyStack st = new MyStack();

        // add elements to the stack
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(-10);

        // size of the stack
        System.out.println("size: " + st.size());

        // topmost element of the stack
        System.out.println("peek: " + st.peek());

        // size of the stack
        System.out.println("size: " + st.size());

        // remove from the stack
        System.out.println("pop: " + st.pop());

        // size of the stack
        System.out.println("size: " + st.size());

        // size of the stack
        System.out.println("peek: " + st.peek());
    }    
}
