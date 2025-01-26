public class ArrayStack<T> implements MyStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;
    private int top; // Index of the top element

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        arr = (T[]) new Object[capacity];
        top = -1;
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void push(T item) {
        if (top == arr.length - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        arr[++top] = item;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        T item = arr[top];
        arr[top--] = null; // Help garbage collector
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }
}
