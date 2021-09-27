package com.company;


class Queue {
    RedBlackNode front, rear;

    public Queue()
    {
        this.front = this.rear = null;
    }

    // Method to add an key to the queue.
    // Method to add an key to the queue.
    void enqueue(RedBlackNode node)
    {

        // Create a new LL node
        RedBlackNode temp = node;

        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }
    void enqueueB(RedBlackNode node)
    {


        RedBlackNode temp = node;



        // If queue is empty, then new node is front and rear both
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }

        // Add the new node at the end of queue and change rear
        this.rear.next = temp;
        this.rear = temp;
    }

    // Method to remove an key from queue.
    void dequeue()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return;

        // Store previous front and move front one node ahead
        RedBlackNode temp = this.front;
        this.front = this.front.next;


        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
    }

    RedBlackNode dequeueB()
    {
        // If queue is empty, return NULL.
        if (this.front == null)
            return null;

        // Store previous front and move front one node ahead
        RedBlackNode temp = this.front;
        this.front = this.front.next;



        // If front becomes NULL, then change rear also as NULL
        if (this.front == null)
            this.rear = null;
        return temp;
    }

}
