import java.util.*;
public class StackDSA {

    public void insertAtBttom(Stack<Integer> s, int data){
        //base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        insertAtBttom(s,data);
        s.push(top);
    }
    public void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
//            System.out.println("Stack is Empty");
            return;
        }
        StackDSA a = new StackDSA();
        int top = s.pop();
        reverseStack(s);
        a.insertAtBttom(s,top);

    }
    public void print(Stack<Integer> s){
        Stack<Integer> st = new Stack<>();
        st.addAll(s);
        while(!st.isEmpty()){
            System.out.print(st.peek()+" ");
            st.pop();
        }
        System.out.println();
    }
    public static void main(String[] args) {
        StackDSA st = new StackDSA();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        int a = s.peek();
        System.out.println(a);
        st.print(s);
        st.insertAtBttom(s,4);
        st.print(s);//it will delete all the stack
        st.reverseStack(s);
        st.print(s);

    }
}
