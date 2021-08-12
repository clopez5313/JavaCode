public class SortStack {

	public static void main(String[] args) {
		MyStack stackCustom = new MyStack(10);
        System.out.println("=================");
        stackCustom.push(10);
        stackCustom.push(30);
        stackCustom.push(50);
        stackCustom.push(40);
        stackCustom.printStack(stackCustom);
        MyStack sortedStack=sortStack(stackCustom);
        System.out.println("=================");
        System.out.println("After Sorting :");
        System.out.println("=================");
        sortedStack.printStack(sortedStack);
	}

	public static MyStack sortStack(MyStack stack)
	{
		MyStack tempStack = new MyStack(10);

		while(!stack.isEmpty())
		{
			int currentData=stack.pop();

			while(!tempStack.isEmpty() && tempStack.peek() > currentData) {
				stack.push(tempStack.pop());
			}

			tempStack.push(currentData);
		}

		return tempStack;
	}
}

class MyStack {
	int size;
    int arr[];
    int top;

    MyStack(int size) {
    	this.size = size;
    	this.arr = new int[size];
    	this.top = -1;
    }

    public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void push(int pushedElement) {
        if (!isFull()) {
            top++;
            arr[top] = pushedElement;
        } else {
            System.out.println("Stack is full !");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int returnedTop = top;
            top--;
            return arr[returnedTop];

        } else {
            System.out.println("Stack is empty !");
            return -1;
        }
    }

    public int peek() {
        return arr[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public  void printStack(MyStack stack)
    {
        int[] nArr = stack.getArr();

    	if(stack.getTop() >= 0)
        {
            System.out.println("Elements of stacks are:");

            for (int i = 0; i <= stack.getTop(); i++) {
                System.out.println(nArr[i]);
            }
        }

    }
}
