
// Node class with a generic type
class Node<E> {
    E data;
    Node<E> next;

    public Node(E data, Node<E> next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return this.data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setNext(Node<E> n) {
        this.next = n;
    }
}

// Circular Linked List class
class CircularLinkedList<E> {
    private Node<E> tail;
    private Node<E> head;
    private int size;

    public CircularLinkedList() {
        this.tail = null;
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data, head);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
        size++;
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<>(data, head);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.setNext(head);
        } else {
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(head);
        }
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) return;
        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.setNext(head);
        }
        size--;
    }

    public void removeNode(E key) {
        if (isEmpty()) return;
        if (head.getData().equals(key)) {
            removeFirst();
            return;
        }
        removeNodeRecursive(head, key);
    }

    private void removeNodeRecursive(Node<E> current, E key) {
        if (current.getNext() == tail.getNext()) {
            System.out.println("Item '" + key + "' does not exist in the list.");
            return;
        }
        if (current.getNext().getData().equals(key)) {
            if (tail == current.getNext()) tail = current;
            current.setNext(current.getNext().getNext());
            size--;
            return;
        }
        removeNodeRecursive(current.getNext(), key);
    }

    public void addAtPosition(E data, int position) {
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position. Please enter a valid index.");
            return;
        }
        if (position == 1) {
            addFirst(data);
            return;
        }
        if (position == size + 1) {
            addLast(data);
            return;
        }
        addAtPositionRecursive(head, data, position, 1);
    }

    private void addAtPositionRecursive(Node<E> current, E data, int position, int index) {
        if (index == position - 1) {
            Node<E> newNode = new Node<>(data, current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == head) tail = newNode;
            size++;
            return;
        }
        addAtPositionRecursive(current.getNext(), data, position, index + 1);
    }

    public void findNode(E key) {
        System.out.println("Searching for value: '" + key + "'");
        findNodeRecursive(head, key, 1);
    }

    private void findNodeRecursive(Node<E> current, E key, int index) {
        if (current == tail.getNext()) {
            System.out.println("Value '" + key + "' not found in the list.");
            return;
        }
        if (current.getData().equals(key)) {
            System.out.println("Value '" + key + "' is located at position " + index);
            return;
        }
        findNodeRecursive(current.getNext(), key, index + 1);
    }

    public E first() {
        return isEmpty() ? null : head.getData();
    }

    public E last() {
        return isEmpty() ? null : tail.getData();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The list is currently empty.");
            return;
        }
        System.out.println("Current elements in the list:");
        displayRecursive(head, 1);
        System.out.println();
    }

    private void displayRecursive(Node<E> current, int index) {
        if (current == tail.getNext()) return;
        System.out.print("Position " + index + " -> " + current.getData() + "    ");
        displayRecursive(current.getNext(), index + 1);
    }
}

// **Testing the Circular Linked List**
public class LinkedListTest {
    public static void main(String[] args) {
        CircularLinkedList<Integer> myList = new CircularLinkedList<>();

        System.out.println("***** Initial List Display *****");
        myList.addFirst(10);
        myList.addFirst(20);
        myList.addFirst(30);
        myList.addFirst(40);
        myList.display();

        System.out.println("***** Adding Elements at the End *****");
        myList.addLast(100);
        myList.addLast(200);
        myList.display();

        System.out.println("***** Inserting Elements at Specific Positions *****");
        myList.addAtPosition(19, 1);
        myList.addAtPosition(29, 6);
        myList.addAtPosition(99, 9);
        myList.display();

        System.out.println("First element: " + myList.first());
        System.out.println("Last element: " + myList.last());

        System.out.println("\n***** Removing First & Specific Nodes *****");
        myList.removeFirst();
        myList.display();
        myList.removeNode(99);
        myList.display();

        System.out.println("\n***** Attempting to Delete Non-Existent Node *****");
        myList.removeNode(9);
        System.out.println();

        System.out.println("***** Searching for Elements *****");
        myList.findNode(99);
        System.out.println();
        myList.findNode(100);
    }
}
