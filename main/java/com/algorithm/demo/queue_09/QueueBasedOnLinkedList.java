package com.algorithm.demo.queue_09;

import com.algorithm.demo.linkedlist_07.LNode;

public class QueueBasedOnLinkedList {

    private LNode head;
    private LNode tail;

    public QueueBasedOnLinkedList(){
        head = null;
        tail = head;
    }

    public void enqueue(String item){
        if(tail==null){
            LNode node= new LNode(item);
            head = tail = node;
        }else{
            LNode node= new LNode(item);
            tail.setNext(node);
            tail = tail.getNext();
        }
    }

    public void dequeue(){
        if(head==null){
            System.out.println("队列为空");
            return;
        }
        if(head==tail){
            System.out.println("出队：" + head.getElement());
            head = tail = null;
            return;
        }
        System.out.println("出队：" + head.getElement());
        head = head.getNext();
    }

    public void printAll(){
        LNode node = head;
        System.out.print("队列包含");
        while(node !=null){
            System.out.print(" -> "+node.getElement());
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
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
