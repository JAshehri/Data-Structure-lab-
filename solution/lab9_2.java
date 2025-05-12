public class lab9_2 {
    private int[] queue;
    private int frontIndex = 0;
    private int rearIndex = 0;
    private int maxSize;
    private int itemCount = 0;

    public Main(int capacity) {
        queue = new int[capacity];
        maxSize = capacity;
    }

    public void insert(int value) {
        if (isFull()) {
            System.out.println("Cannot insert, queue is full.");
            return;
        }
        queue[rearIndex] = value;
        rearIndex = (rearIndex + 1) % maxSize;
        itemCount++;
        System.out.println(value + " inserted.");
    }

    public int remove() {
        if (isEmpty()) {
            System.out.println("Cannot remove, queue is empty.");
            return -1;
        }
        int removedValue = queue[frontIndex];
        frontIndex = (frontIndex + 1) % maxSize;
        itemCount--;
        System.out.println(removedValue + " removed.");
        return removedValue;
    }

    public boolean isFull() {
        return itemCount == maxSize;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public int peekFront() {
        return queue[frontIndex];
    }

    public int peekRear() {
        return queue[(rearIndex - 1 + maxSize) % maxSize];
    }

    public int currentSize() {
        return itemCount;
    }

    public void printQueue() {
        System.out.println("\n--- Queue Content ---");
        if (isEmpty()) {
            System.out.println("Queue is currently empty.");
            return;
        }

        int index = frontIndex;
        for (int i = 0; i < itemCount; i++) {
            System.out.print(queue[index] + " ");
            index = (index + 1) % maxSize;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Main queue = new Main(5);

        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        queue.printQueue();

        queue.remove();
        queue.remove();
        queue.remove();

        queue.printQueue();

        queue.insert(60);

        queue.printQueue();
    }
}
