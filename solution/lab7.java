
// lab 7 array

class StackArray {
    private int[] stack;
    private int top;
    private int capacity;

    public StackArray(int size) {
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        top=top+1;
        stack[top] = value;
        System.out.println("Pushed: " + value);
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return ;
        }
        int temp = stack[top];
        top=top-1;
        System.out.println(temp+ "popped ");

    }

    public int top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public void makeEmpty() {
        top = -1;
        System.out.println("Stack is now empty.");
    }
}

//lab 7 linked list

class StackLinkedList {
    private static class Node {
        private int data;
        private Node next;
        
        public Node ( int e , Node n){
            this.data= e;
            this.next=n;
        }
        
        public int getElement(){
            return this.data;
        }
        public Node getLink(){
            return this.next;
        }
        public void setLink(Node n){
            this.next=n;
        }
        
    }

    private Node top=null;
    private int size=0;

    public StackLinkedList() {

    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void push(int value) {
        System.out.println("Push method");
        Node newNode = new Node(value,null);
        newNode.setLink(top);
        top = newNode;
        size++;
        System.out.println("Pushed: " + value);
    }

    public void pop() {
        System.out.println("pop method()");
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return ;
        }
        System.out.println(top.data+"is popped");
        top=top.next;
        size--;
    }

    public void top() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return ;
        }
        System.out.println("Top element of Stack"+top.data );
    }

    public int size() {
        return size;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        System.out.print("Stack elements: ");
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void makeEmpty() {
        top = null;
        size = 0;
        System.out.println("Stack is now empty.");
    }
}

public class Main {
    public static void main(String[] args) {

        StackArray S1 = new StackArray(5);
        
        S1.push(5);
        System.out.println("Top: " + S1.top());
        
        S1.push(10);
        System.out.println("Top: " + S1.top());
        
        S1.push(15);
        System.out.println("Top: " + S1.top());
        
        S1.display();

        StackLinkedList S2 = new StackLinkedList();
        

        while (!S1.isEmpty()) {
            int value = S1.top();
            S1.pop();
            S2.push(value);
        }

        S2.display();
    }
}