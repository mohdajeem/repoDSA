import java.util.Stack;

public class ReverseStringInStack {
    public String reverseString(String st){
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx<st.length()){
            s.push(st.charAt(idx));
            idx++;
        }
        StringBuilder str = new StringBuilder();
        while(!s.isEmpty()){
            char curr = s.pop();
            str.append(curr);
        }

        return str.toString();
     }

    public static void main(String[] args) {
        String s = "hello";
        ReverseStringInStack st = new ReverseStringInStack();
        System.out.println(st.reverseString(s));
    }
}
