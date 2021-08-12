public class StackWLinkedList {

	public static void main(String[] args) throws Exception {
        TheStack stack=new TheStack();
        stack.push(200);
        stack.push(150);
        stack.push(80);
        stack.push(90);
        stack.push(600);
        stack.push(175);
        System.out.println("Removed element from LinkedList: "+stack.pop());
        System.out.println("Removed element from LinkedList: "+stack.pop());
        stack.push(100);
        System.out.println("Removed element from LinkedList: "+stack.pop());
        stack.printList(stack.getHead());
	}
}

class TheStack {
	private Node head; // the first node

	TheStack() {
		head = null;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

    // Remove value from the beginning of the list to simulate stack
    public int pop() throws Exception {
        if (head == null) {
            throw new Exception();
        }

        int value = head.value;
        head = head.next;
        return value;
    }

    // Add value to the beginning of the list to simulate stack
    public void push(int value) {
        Node prevHead = head;
        head = new Node();
        head.value = value;
        head.next = prevHead;
    }

    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int value;
    Node next;
}
