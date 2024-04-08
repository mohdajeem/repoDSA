import java.util.*;
public class InsertListToLL {
    public static class Node {
        int data;
        Node next;

        //constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static Node head=null;
    public static Node tail=null;
    public static int size;
    public void addFirst(int data){
        Node newNode = new Node(data);
        //Base case
        if(head == null){
            head  = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    // counting Size of Linked List
    public static int sizeOfLL(){
        Node temp = head;
        int sizeF = 0;
        while(temp!=null){
            sizeF++;
            temp = temp.next;
        }
        return  sizeF;
    }

    //add last
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            tail=newNode;
            size++;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    public void Print(){
        if(head == null){
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }


    // remove from the linked list function

    //1. remove from first
    public int removeFirst(){
        if(head == null){
            System.out.println("Linked list is empty");
            return -12132131;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast(){
        if(head == null){
            System.out.println("linked list is empty");
            return -121212;
        } else if(size == 1){
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        Node temp = head;
        for(int i =0; i<size-2; i++){
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }

    /*Search in a linked List */
//    iterative search
    public int itrSearch(int val){
        Node temp = head;
        int i = 0;
        while(temp!=null){
            if(temp.data == val){
                return i;
            } else{
                temp = temp.next;
                i++;
            }
        }
        return -1;
    }

    // recursive search
    public int recHelper(Node head, int val){
        if(head == null){
            return -1;
        } if(head.data == val){
            return 0;
        }
        int index = recHelper(head.next,val);
        if(index == -1){
            return -1;
        }
        return index+1;
    }
    public int recSearch(int val){
        return recHelper(head,val);
    }

    //    reverse a Linked List
    public void reverse(){
        Node next;
        Node curr = tail = head;
        Node prev=null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    //    find and remove nth element from the last
    public void removeFromEnd(int n){
        Node temp = head;
        int size = 0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(size == n){
            head = head.next;
            return;
        }
        int i = 1;
        int iToFind = size - n +1;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;// cycle doesn't exists;
    }
    /*
    public void insertList(Node ll1, Node ll2, int a, int b){
        Node temp =
    }*/
    public static void main(String[] args) {
        InsertListToLL ll1 = new InsertListToLL();

        ll1.addFirst(1);
        ll1.addLast(2);
        ll1.addLast(3);
        ll1.addLast(4);
        ll1.addLast(5);
        ll1.Print();

        InsertListToLL linkedList2 = new InsertListToLL();
        linkedList2.addFirst(6);
        linkedList2.addLast(7);
        linkedList2.addLast(8);
        linkedList2.Print();
        ll1.Print();
    }
}
