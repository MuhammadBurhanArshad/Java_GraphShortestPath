/*
 * Custom Queue implementation for BFS
 * 
 * @variables:
    * front: Represents the front of the queue
    * rear: Represents the rear of the queue
    * size: Represents the current size of the queue
    * queue: Represents the array to store the queue elements
    * capacity: Represents the maximum capacity of the queue
 *
 * @methods:
    * CustomQueue(int capacity): Initializes the queue with the given capacity
    * enqueue(Vertex vertex): Adds an element to the queue
    * dequeue(): Removes and returns the front element from the queue
    * isEmpty(): Checks if the queue is empty
    * isFull(): Checks if the queue is full
 */

class CustomQueue {
    private int front, rear, size;
    private Vertex[] queue;
    private int capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new Vertex[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(Vertex vertex) {
        if (size == capacity) {
            System.out.println("Queue overflow");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = vertex;
        size++;
    }

    public Vertex dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return null;
        }
        Vertex vertex = queue[front];
        front = (front + 1) % capacity;
        size--;
        return vertex;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
