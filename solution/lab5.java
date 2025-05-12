class Node<E>{
    private Node<E> next;
    private Node<E> prev;
    private E data;
    
    Node(Node<E> next , Node<E> prev , E data){
        this.next=next;
        this.prev=prev;
        this.data=data;
    }
    
    public Node<E> getNext(){
        return next;
    }
    
    public Node<E> getprev(){
        return prev;
    }
    
    public E getdata(){
        return data;
    }
    
    public void setNext(Node<E> next){
        this.next=next;
    }
    
    public void setprev(Node<E> prev){
        this.prev=prev;
    }
    public void setdata(E data){
        this.data=data;
    }
}

class Dlinkedlist<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void addFirst(E data) {
        Node<E> node = new Node<>(head, tail, data);

        if (isEmpty()) {
            head = tail = node;
            node.setNext(head);
            node.setprev(head);
        } else {
            node.setNext(head);
            head.setprev(node);
            node.setprev(tail);
            tail.setNext(node);
            head = node;
        }
        size++;
    }

    public void addLast(E data) {
        Node<E> node = new Node<>(head, tail, data);

        if (isEmpty()) {
            head = tail = node;
            node.setNext(head);
            node.setprev(head);
        } else {
            node.setprev(tail);
            tail.setNext(node);
            node.setNext(head);
            head.setprev(node);
            tail = node;
        }
        size++;
    }

    public void find(E key) {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        boolean flag = false;
        Node<E> current = head;
        int count = 1;

        for (int i = 0; i < size; i++) {
            if (current.getdata().equals(key)) {
                flag = true;
                break;
            }
            current = current.getNext();
            count++;
        }
        if (flag) {
            System.out.println(key + " exists in the list at node #" + count);
        } else {
            System.out.println("No record found");
        }
    }

    public void delete(E key) {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        Node<E> current = head;
        Node<E> prev = head;

        while (!current.getdata().equals(key)) {
            if (current.getNext() == head) {
                System.out.println("Can't find the value");
                return;
            }
            prev = current;
            current = current.getNext();
        }

        prev.setNext(current.getNext());
        current.getNext().setprev(prev);

        if (current == head) {
            head = current.getNext();
        }
        if (current == tail) {
            tail = prev;
        }

        size--;
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setprev(tail);
            tail.setNext(head);
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
        if (size == 1) {
            head = tail = null;
        } else {
            tail = tail.getprev();
            tail.setNext(head);
            head.setprev(tail);
        }
        size--;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("List is Empty");
            return;
        }
    
        Node<E> current = head;
        System.out.print("List: ");
        for (int i = 0; i < size; i++) {
            System.out.print(current.getdata() + "\t");
            current = current.getNext();
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Dlinkedlist<Integer> list = new Dlinkedlist<>();

        System.out.println("Initial List:");
        list.display();

        System.out.println("\nAdding 10 at the beginning:");
        list.addFirst(10);
        list.display();

        System.out.println("\nAdding 5 at the beginning:");
        list.addFirst(5);
        list.display();

        System.out.println("\nAdding 20 at the end:");
        list.addLast(20);
        list.display();

        System.out.println("\nAdding 25 at the end:");
        list.addLast(25);
        list.display();

        System.out.println("\nFinding 20:");
        list.find(20);
        System.out.println("\nFinding 100:");
        list.find(100);

        System.out.println("\nDeleting 10:");
        list.delete(10);
        list.display();

        System.out.println("\nDeleting the first element:");
        list.deleteFirst();
        list.display();

        System.out.println("\nDeleting the last element:");
        list.deleteLast();
        list.display();

        System.out.println("\nDeleting the first element again:");
        list.deleteFirst();
        list.display();

        System.out.println("\nDeleting from an empty list:");
        list.delete(100);
        list.display();
    }
}