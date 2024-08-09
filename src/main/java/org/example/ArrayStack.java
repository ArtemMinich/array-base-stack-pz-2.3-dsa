package org.example;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
    private int top;
    private T[] storage;

    public ArrayStack(T[] storage) {
        this.top = -1;
        this.storage = storage;
    }

    public boolean push(T data){
        if(isFull()) throw new ArrayIndexOutOfBoundsException();
        top++;
        storage[top] = data;
        return true;
    }

    public T pop(){
        if(isEmpty()) throw new EmptyStackException();
        return storage[top--];
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return storage[top];
    }

    public int size(){
        return top + 1;
    }

    public boolean isFull(){
        return top == storage.length - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }
}
