class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}

class CircularQueue {
    private Node front = null, rear = null;
    private int count = 0;

    public boolean isEmpty() {
        return front == null;
    }

    public int getSize() {
        return count;
    }

    public int getFront() {
        return isEmpty() ? -1 : front.data;
    }

    public int getRear() {
        return isEmpty() ? -1 : rear.data;
    }

    public void Enqueue(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            front = rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        count++;
        System.out.println(value + " - Added to Queue.");
    }

    public void Dequeue() {
        if (isEmpty()) return;
        int deleted = front.data;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }
        count--;
        System.out.println(deleted + " --- Deleted from Queue---");
    }

    public void display() {
        System.out.println("--- Display Method---");
        if (isEmpty()) return;
        Node temp = front;
        do {
            System.out.print("\t" + temp.data);
            temp = temp.next;
        } while (temp != front);
    }
}

public class Main {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        cq.Enqueue(10);
        cq.Enqueue(20);
        cq.Enqueue(30);
        cq.Enqueue(40);
        System.out.println();
        cq.display();
        System.out.println();

        cq.Dequeue();
        System.out.println();
        cq.Dequeue();
        System.out.println();
        System.out.println();

        System.out.println("Front Element: " + cq.getFront());
        System.out.println();
        System.out.println("Rear Element: " + cq.getRear());
        System.out.println();
        cq.Enqueue(50);
        System.out.println();
        System.out.println("--- Display Method---");
        cq.display();
    }
}
