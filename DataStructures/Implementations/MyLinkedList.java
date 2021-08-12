public class MyLinkedList {
    private ListNode head;

    public boolean isEmpty() {
        return (head == null);
    }

    // Method for inserting node at the start of linked list
    public void insertFirst(int data) {
    	ListNode newHead = new ListNode();
        newHead.data = data;
        newHead.next = head;
        head = newHead;
    }

    // Method for deleting node from start of linked list
    public ListNode deleteFirst() {
    	ListNode temp = head;
        head = head.next;

        return temp;
    }

    // Method used to delete node after provided node
    public void deleteAfter(ListNode after) {
    	ListNode temp = head;

    	while (temp.next != null && temp.data != after.data) {
            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    // Method used to insert at end of LinkedList
    public void insertLast(int data) {
    	ListNode current = head;

    	while (current.next != null) {
            current = current.next; // we'll loop until current.next is null
        }

        ListNode newNode = new ListNode();
        newNode.data = data;
        current.next = newNode;
    }

    // Method for printing Linked List
    public void printLinkedList() {
        System.out.println("Printing LinkedList (head --> last) ");
        ListNode current = head;

        while (current != null) {
            current.displayNodeData();
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String args[])
    {
        MyLinkedList myLinkedlist = new MyLinkedList();
        myLinkedlist.insertFirst(50);
        myLinkedlist.insertFirst(60);
        myLinkedlist.insertFirst(70);
        myLinkedlist.insertFirst(10);
        myLinkedlist.insertLast(20);
        myLinkedlist.printLinkedList();
        // Linked list will be
        // 10 -> 70 ->  60 -> 50 -> 20

        System.out.println("=========================");
        System.out.println("Delete node after Node 60");
        ListNode node=new ListNode();
        node.data=60;
        myLinkedlist.deleteAfter(node);
        // After deleting node after 1,Linked list will be
        // 10 -> 70 -> 60 -> 20

        System.out.println("=========================");
        myLinkedlist.printLinkedList();
    }
}

class ListNode {
    public int data;
    public ListNode next;

    public void displayNodeData() {
        System.out.println("{ " + data + " } ");
    }
}
