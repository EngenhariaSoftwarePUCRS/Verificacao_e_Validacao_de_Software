package com.vev;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BoundedIntQueueTests {
    @Test
    void canAddElement() {
        IBoundedIntQueue queue = new BoundedIntQueue(1);
        assertDoesNotThrow(() -> queue.addLast(1), "Queue should accept an element");
    }

    @Test
    void canRemoveElement() {
        IBoundedIntQueue queue = new BoundedIntQueue(1);
        assertDoesNotThrow(() -> {
            queue.addLast(1);
            queue.removeFirst();
        }, "Queue should now be empty");
    }

    @Test
    void canAddAndRemoveElement() {
        IBoundedIntQueue queue = new BoundedIntQueue(1);
        assertDoesNotThrow(() -> queue.addLast(1), "Queue should accept an element");
        assertDoesNotThrow(() -> queue.removeFirst(), "Queue should now be empty");
        assertDoesNotThrow(() -> queue.addLast(1), "Queue should accept an element");
    }

    @Test
    void canNoLongerAddElement() {
        IBoundedIntQueue queue = new BoundedIntQueue(1);
        assertThrows(QueueFullException.class, () -> {
            queue.addLast(1);
            queue.addLast(1);
        }, "Queue should accept only one element");
    }

    @Test
    void hasNoElementToRemove() {
        IBoundedIntQueue queue = new BoundedIntQueue(1);
        assertThrows(QueueEmptyException.class, () -> queue.removeFirst(), "Queue is empty");
    }

    @Test
    void cannotHaveNegativeSize() {
        assertThrows(NegativeArraySizeException.class, () -> new BoundedIntQueue(-1), "Queue cannot have negative size");
    }
}
