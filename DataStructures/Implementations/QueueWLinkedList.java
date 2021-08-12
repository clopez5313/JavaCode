public class QueueWLinkedList {

	public static void main(String[] args) {
        TheQueue queueUsingLinkedList = new TheQueue();
        queueUsingLinkedList.enqueue(60);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(10);
        queueUsingLinkedList.enqueue(20);
        queueUsingLinkedList.enqueue(40);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(70);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(80);
        queueUsingLinkedList.enqueue(100);
        queueUsingLinkedList.dequeue();
        queueUsingLinkedList.enqueue(150);
        queueUsingLinkedList.enqueue(50);
	}
}

class TheQueue {
    private QueueNode front, rear;
    private int currentSize; // size

    //constructor
    public TheQueue()
    {
        front = null;
        rear = null;
        currentSize = 0;
    }

    public boolean isEmpty()
    {
        return (currentSize == 0);
    }

    //Remove item from the beginning of the list to simulate Queue
    public int dequeue()
    {
        int data = front.data;
        front = front.next;

        if (isEmpty())
        {
            rear = null;
        }

        currentSize--;
        System.out.println(data+ " removed from the queue");

        return data;
    }

    //Add data to the end of the list to simulate Queue
    public void enqueue(int data)
    {
    	QueueNode oldRear = rear;
        rear = new QueueNode();
        rear.data = data;
        rear.next = null;

        if (isEmpty())
        {
            front = rear;
        }

        else
        {
            oldRear.next = rear;
        }

        currentSize++;
        System.out.println(data+ " added to the queue");
    }
}

//Node data structure
class QueueNode
{
    int data;
    QueueNode next;
}
