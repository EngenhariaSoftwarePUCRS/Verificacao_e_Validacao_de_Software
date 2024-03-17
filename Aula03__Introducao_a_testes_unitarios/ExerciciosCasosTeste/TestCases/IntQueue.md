| Input | Expected Output | Actual Output | Pass/Fail |
| --- | --- | --- | --- |
| Queue(1), addLast(), addLast() | QueueFullException | QueueFullException | Pass |
| Queue(1), removeFirst() | QueueEmptyException | QueueEmptyException | Pass |
| Queue(1), addLast(), removeFirst() | 1 | 1 | Pass |
| Queue(-1) | NegativeArraySizeException | NegativeArraySizeException | Pass |
