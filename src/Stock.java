import java.util.Stack;

public class Stock {
    public void stockHigh(int[] stock, int[] span){
        Stack<Integer> s = new Stack<>();
        span[0]=1;
        s.push(0);
        for(int i = 0; i<stock.length;i++){
            int currPrice = stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            } else{
                int prevHigh = s.peek();
                span[i] = i-prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        Stock st = new Stock();
        int[] arr = {100,80,60,70,85,100};
        int[] res = new int[6];
        st.stockHigh(arr,res);
        for(int i = 0;i<6;i++){
            System.out.print(res[i]+" ");
        }


    }
}
