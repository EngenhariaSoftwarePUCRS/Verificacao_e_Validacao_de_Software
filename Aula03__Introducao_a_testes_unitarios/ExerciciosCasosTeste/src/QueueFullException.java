public class QueueFullException extends Exception {
    public QueueFullException() {
        super("Queue is full");
    }    
}
