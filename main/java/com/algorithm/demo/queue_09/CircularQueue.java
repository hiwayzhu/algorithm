package com.algorithm.demo.queue_09;

public class CircularQueue {
    private String[] arr;
    private static final Integer DEFAULT_CAPACITY=16;
    private int count;
    private int capacity;
    private int head;
    private int tail;

    public CircularQueue(){
        arr = new String[DEFAULT_CAPACITY];
        head = tail = count = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public CircularQueue(int capacity){
        arr = new String[capacity];
        this.capacity = capacity;
        head = tail = count = 0;
    }

    public void enqueue(String item){
        if(count == capacity){
            System.out.println("队列满了");
            return;
        }
        if(tail==capacity&&count<capacity){
            tail = 0;
        }
        arr[tail] = item;
        tail ++;
        count++;
    }

    public void dequeue(){
        if(count==0){
            System.out.println("队列为空");
            return;
        }
        if(head==capacity&&count<capacity){
            head=0;
        }
        System.out.println("出队"+arr[head]);
        arr[head] = null;
        head++;
        count--;
    }

    public void printAll(){
        System.out.print("队列包含");
        for(int i = head,j=0;j<capacity;i=(i+1)%capacity,j++){
            System.out.print(" -> "+arr[i]);
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.dequeue();
        queue.enqueue("f");
        queue.printAll();
    }
}
