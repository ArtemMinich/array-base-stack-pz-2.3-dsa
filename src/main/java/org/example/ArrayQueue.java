package org.example;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayQueue<T> {

    private static final int INITIAL_SIZE = 10;
    private int size;
    private int front;
    private int rear;
    private T[] items;

    public ArrayQueue() {
        size = INITIAL_SIZE;
        items = (T[]) new Object[INITIAL_SIZE];
        front = -1;
        rear = -1;
    }

    public boolean enqueue(T data){
        if(isFull()) throw new IllegalStateException("queue is full");
        if(front == -1){
            front = 0;
        }
        rear = ( rear + 1 ) % size;
        items[rear] = data;
        size++;
        return true;
    }

    public T dequeue(){
        if(isEmpty()) throw new NoSuchElementException("stack is empty");
        T result = items[front];
        if(front == rear)
        {
            front = -1;
            rear = -1;
        } else {
            front =  (front + 1) % size;
        }
        size--;
        return result;
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return items[front];
    }

    public boolean isEmpty(){
        return front == -1;
    }

    public boolean isFull(){
        return ((rear + 1) % size == front);
    }

    public int size(){
        return size;
    }

}
