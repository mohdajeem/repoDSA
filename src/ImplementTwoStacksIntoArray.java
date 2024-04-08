import java.util.Arrays;

public class ImplementTwoStacksIntoArray {
    static class TwoStacks{
        int[] arr;
        int top1;
        int top2;
        int size;

        TwoStacks(int size){
            this.size = size;
            arr = new int[size];
            top1 = -1;
            top2 = size;
        }

        void push1(int x){
            if(top2-top1<=1){
                return;
            }
            top1++;
            arr[top1] = x;
        }
        void push2(int x){
            if(top2-top1<=1){
                return;
            }
            top2--;
            arr[top2] = x;
        }

        int pop1(){
            if(top1 == -1){
                return -1;
            }
            int val = arr[top1];
            top1--;
            return val;
        }
        int pop2(){
            if(top2==size){
                return -1;
            }
            int val = arr[top2];
            top2++;
            return val;
        }


    }
    public static void main(String[] args)
        TwoStacks st = new TwoStacks(10);
        st.push1(1);
        st.push2(10);
        st.push1(2);
        st.push2(9);
        System.out.println(st.pop1());
        System.out.println(Arrays.toString(st.arr));
    }
}
