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
    
    public Node<E> addLast(E data) {
        Node<E> newNode = new Node<E>(data, null);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;  
        }
        size++;
        return newNode;
    }
    
    public Node<E> addNode(E data, int index) {
        if (index == 1) {
            addFirst(data);
            return head;
        }
        Node<E> newNode = new Node<>(data, null);
        Node<E> current = head;
        int count = 1;
        while (count < index - 1 && current.getNext() != null) {
            current = current.getNext();
            count++;
        }
        newNode.setNext(current.getNext());
        current.setNext(newNode);
        if (newNode.getNext() == null) {
            tail = newNode;
        }
        size++;
        return newNode;
    }
    
    public Node<E> addAfter(E data, E key) {
    Node<E> current = head;
    while (current != null && !current.getElement().equals(key)) {
        current = current.getNext();
    }
    
    if (current == null) {
        System.out.println("Error, no node has the given id");
        return null;
    }
    
    Node<E> newNode = new Node<>(data, current.getNext());
    current.setNext(newNode);
    if (current == tail) {
        tail = newNode;
    }
    size++;
    return newNode;
}

    public Node<E> removeFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        Node<E> removedNode = head;
        head = head.getNext();
        size--;
        if (head == null) {
            tail = null;
        }
        return removedNode;
    }
    
    public Node<E> removeNode(E value) {
        Node<E> current = head;
        Node<E> previous = null;
        
        while (current != null && !current.getElement().equals(value)) {
            previous = current;
            current = current.getNext();
        }
        
        if (current == null) {
            System.out.println("Value doesn't exist");
            return null;
        }
        
        if (current == head) {
            return removeFirst();
        } else {
            previous.setNext(current.getNext());
            if (current == tail) {
                tail = previous;
            }
            size--;
            return current;
        }
    }
    
    public E first() {
    if (isEmpty()) {
        System.out.println("Empty list");
        return null;
    }
    return head.getElement();
}

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    
}

public class lab3_2 {
    public static void main(String[] args) {
        
        LinkedList myList = new LinkedList();
        
        myList.addFirst(100);
        myList.addFirst('C');
        myList.addFirst("Sara");
        myList.display();
        
        System.out.println("\n\nFirst Node: " + myList.first());
        System.out.println("Last Node: " + myList.last());
                
        System.out.print("\n**** Testing AddLast method ****");
        myList.addLast(20.5);
        myList.display();

        System.out.print("\n\n**** Testing AddNode method ****");
        myList.addNode('A' , 4);
        myList.display();
        myList.addNode("First" , 1);
        myList.display();
        myList.addNode("Last", myList.size() + 1);
        myList.display();
        
        System.out.print("\n\n**** Testing RemoveFirst method ****");
        myList.removeFirst();
        myList.display();
        
        System.out.print("\n\n**** Testing RemoveNode method ****");
        myList.removeNode(200);
        myList.removeNode(100);
        myList.display();
    }
    
}


