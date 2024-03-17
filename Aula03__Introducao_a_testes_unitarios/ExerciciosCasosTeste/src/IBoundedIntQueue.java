public interface IBoundedIntQueue {
    int capacity();
    int size();
    boolean isEmpty();
    boolean isFull();
    void addLast(int newElement) throws QueueFullException;
    int removeFirst() throws QueueEmptyException;
}
