public class LinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;

    public void addFirst(int data) {
        //create a newNode
        Node newNode = new Node(data);
        //base case
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        tail = newNode;
        size++;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // move last element to first position
    public void moveToFirst(){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        Node second_last = temp;
        Node last = temp.next;

        // process
        second_last.next = null;
        last.next = head;
        head = last;
    }
    // -----------------Add 1 to a number represented as linked list---------------
    public int addOneToLL(){
        Node temp = head;
        int n = 0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        temp = head;
        int result = 0;
        while(size>0){
            result += (temp.data)*(Math.pow(10,size-1));
            temp = temp.next;
            size--;
        }
        return result+1;
    }

    // adding two numbers represents linkedList
    public int addTwoLL(){
        Node temp = head;
        int n = 0;
        while(temp!=null){
            temp=temp.next;
            n++;
        }
        temp = head;
        int result = 0;
        while(size>0){
            result += (temp.data)*(Math.pow(10,size-1));
            temp = temp.next;
            size--;
        }
        return result;
    }


    // main function
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(5);
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.print();
        System.out.println(size);
        ll.moveToFirst();
        ll.print();
        System.out.println(ll.addOneToLL());
        int nl1 = ll.addTwoLL();
        System.out.println("nl1"+nl1);
        int nl2 = ll.addTwoLL();
        int res = nl1 + nl2;
        System.out.println("result"+res);


    }
}