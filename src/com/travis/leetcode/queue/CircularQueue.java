package com.travis.leetcode.queue;

import java.util.Scanner;

public class CircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public CircularQueue(int k) {
        this.data = new int[k];
        this.size = k;
        this.head = -1;
        this.tail = -1;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }

        if (isEmpty()) {
            head = 0;
        }

        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public int front() {
        if (isEmpty()) {
            return -1;
        }
        return data[head];
    }

    public int rear() {
        if (isEmpty()) {
            return -1;
        }
        return data[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public void print() {
        for (int item : data) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Create new circular queue. Please enter the size of queue: ");
        int size = Integer.parseInt(sc.next().trim());
        CircularQueue queue = new CircularQueue(size);

        boolean isStop = false;

        while (!isStop) {
            System.out.println("----------------------------------------------------------------");
            System.out.print("Current data: ");
            queue.print();
            System.out.println("1. front() -> Gets the front item from the queue. If the queue is empty, return -1.");
            System.out.println("2. rear() -> Gets the last item from the queue. If the queue is empty, return -1.");
            System.out.println("3. enqueue(int value) -> Inserts an element into the circular queue. Return true if the operation is successful.");
            System.out.println("4. dequeue() -> Deletes an element from the circular queue. Return true if the operation is successful.");
            System.out.println("5. isEmpty() -> Checks whether the circular queue is empty or not.");
            System.out.println("6. isFull() -> Checks whether the circular queue is full or not.");
            System.out.println("0. Exit");
            System.out.println("----------------------------------------------------------------");

            System.out.print("Please choose an option: ");
            String option = sc.next();

            switch (option) {
                case "1":
                    System.out.println(queue.front());
                    break;

                case "2":
                    System.out.println(queue.rear());
                    break;

                case "3":
                    System.out.print("Please enter the value: ");
                    int value = Integer.parseInt(sc.next().trim());
                    System.out.println(queue.enqueue(value));
                    break;

                case "4":
                    System.out.println(queue.dequeue());
                    break;

                case "5":
                    System.out.println(queue.isEmpty());
                    break;

                case "6":
                    System.out.println(queue.isFull());
                    break;

                case "0":
                    isStop = true;
                    break;

                default:
                    System.out.println("Try again!");
            }
        }
    }
}
