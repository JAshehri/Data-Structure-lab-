class DoubleNode {
    int data;
    DoubleNode prev, next;
    public DoubleNode(int data) {
        this.data = data;
    }
}

class DoubleEndedQueue {
    private DoubleNode front = null, rear = null;
    private int count = 0;

    public boolean isEmpty() {
        return front == null;
    }

    public void EnQueueFront(int value) {
        DoubleNode newNode = new DoubleNode(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        count++;
        System.out.println(value + " - Added to Queue.");
    }

    public void EnQueueRear(int value) {
        DoubleNode newNode = new DoubleNode(value);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        count++;
        System.out.println(value + " - Added to Queue.");
    }

    public void DeQueueFront() {
        if (isEmpty()) return;
        int deleted = front.data;
        front = front.next;
        if (front != null) front.prev = null;
        else rear = null;
        count--;
        System.out.println(deleted + " - Deleted from Queue");
    }

    public void DeQueueRear() {
        if (isEmpty()) return;
        int deleted = rear.data;
        rear = rear.prev;
        if (rear != null) rear.next = null;
        else front = null;
        count--;
        System.out.println(deleted + " - Deleted from Queue");
    }

    public void display() {
        System.out.println("----\nDisplay Method ------");
        DoubleNode temp = front;
        while (temp != null) {
            System.out.print("\t" + temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        DoubleEndedQueue dq = new DoubleEndedQueue();
        dq.EnQueueFront(10);
        dq.EnQueueFront(20);
        dq.EnQueueFront(30);
        dq.EnQueueFront(40);
        dq.EnQueueRear(50);
        dq.EnQueueRear(60);
        dq.display();
        dq.DeQueueFront();
        dq.DeQueueFront();
        dq.DeQueueRear();
        System.out.println("-- Display Method ---");
        dq.display();
    }
}