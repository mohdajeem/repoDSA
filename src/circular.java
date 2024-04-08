public class circular{
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isCycle(){
        Node slow = head;
        Node fast = head;

        while(fast !=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void removeCycle(){
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        slow = head;
        Node previous = head;//last node
        while(slow != fast){
            previous = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // removing circular ll
        previous.next = null;

    }
    public class Solution {
        public Node detectCycle(Node head) {
            //base case
            if(head == null && head.next == null){
                return null;
            }

            // for checking that there is any cycle in ll
            Node slow = head;
            Node fast = head;
            Node entry = head;
            while(fast.next != null && fast.next.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(slow == fast){
                    while(slow != entry){
                        slow = slow.next;
                        entry = entry.next;
                    }
                    return slow;
                }
            }
            // slow = head;
            // while(fast!=null && fast.next != null){
            //     slow = slow.next;
            //     fast = fast.next;
            //     if(slow == fast){
            //         return slow;
            //     }
            // }
            return null;
        }
    }
    public static Node head=null;
    public static Node tail=null;

    /*
    class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptr = list1;
        for(int i = 0; i<a-1;i++){
            ptr = ptr.next;
        }
        ListNode qtr = ptr.next.next;
        for(int i = a; i<(b); i++){
            qtr = qtr.next;
        }
        ptr.next = list2;
        while(list2.next != null){
            list2 = list2.next;
        }
        list2.next = qtr;
        return list1;
    }
     */

    public static void main(String[] args){
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());

    }
}