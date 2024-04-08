public class RemoveDuplicate {
    public static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode = temp;

    }
    public int removeDuplicate(){
        Node curr = head;
        while(curr.next != null){
            if(curr.data == curr.next.data){
                int val = curr.data;
                return val;
            }
            curr = curr.next;
        }
        return -1;
    }
    public void print(){
        Node temp = head;
        while(temp.next != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void removeDuplicateUnSorted(){
        Node ptr1 = head, ptr2 = null;
        while(ptr1.next != null){
            ptr2 = ptr1;
            while(ptr2.next != null){
                if(ptr1.data == ptr2.next.data){
                    ptr2 = ptr2.next.next;
                }
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
        }

    }

    public static void main(String[] args) {
        head = new Node(5);
        RemoveDuplicate ll = new RemoveDuplicate();
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        // 1->2->3->4->4->5->null
        ll.print();
//        int a = ll.removeDuplicate();
//        System.out.println("duplicate is "+ a);
        System.out.println("new Linked List: ");
        ll.removeDuplicateUnSorted();
        ll.print();
    }
}
