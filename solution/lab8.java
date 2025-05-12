import java.util.Scanner;

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

    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }

    public int size() {
        return top + 1;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int number = input.nextInt();
        input.close();

        StackArray stack = new StackArray(8);
        int count = 0;

        while (number > 0) {
            int digit = number % 2;
            stack.push(digit);
            number /= 2;
            count++;
        }

        while (count < 8) {
            stack.push(0);
            count++;
        }

        System.out.print("Binary: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}