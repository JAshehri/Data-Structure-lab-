class Node<E> {
    private E element;
    private Node<E> next;

    public Node(E element, Node<E> next) {
        this.element = element;
        this.next = next;
    }

    public E getElement() {
        return element;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}

class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public LinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data, head);
        head = newNode;
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Empty List");
            return;
        }
        Node<E> current = head;
        int counter = 1;

        while (current != null) {
            System.out.println("Node# " + counter + ": " + current.getElement());
            current = current.getNext();
            counter++;
        }
    }

    public Node<E> findNode(E key) {
        Node<E> current = head;
        int counter = 1;
        while (current != null) {
            if (current.getElement().equals(key)) {
                System.out.println("Value found at Node " + counter);
                return current;
            }
            current = current.getNext();
            counter++;
        }
        System.out.println("Value not found.");
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList<Object> myList = new LinkedList<>();
        System.out.println("***The Linked List Before adding elements***");
        myList.display();

        System.out.println("\n\n***The Linked List After Adding elements***");
        myList.addFirst("First Element");
        myList.display();
        myList.addFirst(100);
        myList.display();
        myList.addFirst('C');
        myList.display();
        myList.addFirst(50.5);
        myList.display();
        myList.addFirst("Sara");
        myList.display();
        System.out.println();
        myList.findNode(2);
        myList.findNode("Sara");
    }
}