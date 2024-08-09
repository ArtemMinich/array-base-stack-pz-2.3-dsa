package org.example;

public class CircularQueue<T> {

    private Node first;

    private Node rare;

    private int size;

    public void enqueue(T data) {
        Node newNode = new Node(data);

        if (first == null) {
            first = newNode;
        } else {
            rare.nextNode = newNode;
        }

        rare = newNode;
        rare.nextNode = first;
        size++;
    }

    public void dequeue(T valueToDelete) {
        Node currentNode = first;
        if (first == null) {
            return;
        }
        do {
            Node nextNode = currentNode.nextNode;
            if (nextNode.value == valueToDelete) {
                if (rare == first) {
                    first = null;
                    rare = null;
                } else {
                    currentNode.nextNode = nextNode.nextNode;
                    if (first == nextNode) {
                        first = first.nextNode;
                    }
                    if (rare == nextNode) {
                        rare = currentNode;
                    }
                }
                break;
            }
            currentNode = nextNode;
        } while (currentNode != first);
        size--;
    }

    public void print() {
        Node currentNode = first;

        if (first != null) {
            do {
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.nextNode;
            } while (currentNode != first);
        }
    }

    static class Node<T> {
        T value;
        Node nextNode;

        public Node(T value) {
            this.value = value;
        }
    }
}
