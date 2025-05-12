class LinearQueue {
    private int front = 0;
    private int rear = 0;
    private int currentSize = 0;
    private int capacity;
    private int[] queue;

    public LinearQueue(int size) {
        capacity = size;
        queue = new int[capacity];
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is overflow");
            return;
        }
        queue[rear++] = value;
        currentSize++;
        System.out.println(value + " added to the queue.");
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is underflow");
            return -1;
        }
        int removed = queue[front];
        for (int i = 0; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;
        currentSize--;
        System.out.println(removed + " removed from the queue.");
        return removed;
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("\n--- display Queue elements ---");
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[rear - 1];
    }

    public int getSize() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == capacity;
    }
}

public class lab9 {
    public static void main(String[] args) {
        LinearQueue myQueue = new LinearQueue(5);
        myQueue.enqueue(10);
        myQueue.enqueue(20);
        myQueue.enqueue(30);
        myQueue.enqueue(40);
        myQueue.enqueue(50);

        System.out.println("\nCurrent size: " + myQueue.getSize());
        System.out.println("Front element: " + myQueue.getFront());
        System.out.println("Rear element: " + myQueue.getRear());

        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();

        myQueue.enqueue(60);
        myQueue.displayQueue();
    }
}
