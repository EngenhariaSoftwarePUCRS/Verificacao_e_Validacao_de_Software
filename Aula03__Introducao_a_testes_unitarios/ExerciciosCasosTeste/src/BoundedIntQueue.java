public class BoundedIntQueue implements IBoundedIntQueue {
    private int[] queue;
    private int capacity;
    private int size;
    private int front;
    private int rear;

    public BoundedIntQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void addLast(int newElement) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException();
        }
        queue[rear] = newElement;
        rear = (rear + 1) % capacity;
        size++;
    }

    public int removeFirst() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException();
        }
        int removed = queue[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }
}
