public class queueStruc<T> implements queueInterface<T> {
    private T[] elements;
    private int front;
    private int rear;
    private int size;
    private int count;

    public queueStruc(int size) {
        this.size = size;
        this.front = 0;
        this.elements = (T[]) new Object[size];
        this.rear = -1;
        this.count = 0;
    }

    @Override
    public void offer(T item) {
        if(isFull()) {
            resize();
        }
        rear = (rear + 1) % size;
        elements[rear] = item;
        count++;
    }

    @Override
    public T poll() {
        if(!isEmpty()) {
            T element = elements[front];
            elements[front] = null;
            front = (front + 1)%size;
            count--;
            return element;
        }
        return null;
    }

    @Override
    public T front() {
        if(!isEmpty()) {
            return elements[front];
        }
        return null;
    }

    @Override
    public T back() {
        if(!isEmpty()) {
            return elements[rear];
        }
        return null;
    }
    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public boolean isFull() {
        return count == size;
    }

    private void resize() {
        int newSize = size * 2;
        T[] newElements = (T[]) new Object[newSize];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[(front + i) % size];
        }
        elements = newElements;
        this.front = 0;
        this.rear = count -1;
        this.size = newSize;
    }
}