package com.algorithm.demo;

import java.util.Scanner;

/**
 * 基于单链表的LRU算法
 * 优化：在查找是否含有该element的时候，可以直接返回preNode，这样在删除的时候就不需要再查询一次，如果是双向链表就没有这个问题
 */
public class LRUBaseLinkedList<T> {

    private final static int DEFAULT_CAPACITY = 10;

    private LNode<T> headNode;

    private int capacity;

    private int size;


    public class LNode<T>{
        private T element;
        private LNode next;

        public LNode(T element){
            this.element = element;
        }

        public LNode(T element,LNode next){
            this.element =element;
            this.next = next;
        }

        public LNode(){
            this.element = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public LNode getNext() {
            return next;
        }

        public void setNext(LNode next) {
            this.next = next;
        }
    }

    public LRUBaseLinkedList() {
        this.headNode = new LNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    public void add(T data){
        //LNode node = findNodeByData(data);
        LNode node = findPreNode(data);

        if(node!=null){
            //delNode(node);
            deleteElemOptim(node);
            insertElementAtBegin(data);
        }else{
            if(size>=this.capacity){
                delLastNode();
            }
            insertElementAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(LNode preNode) {
        LNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        size--;
    }

    /**
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private LNode findPreNode(T data) {
        LNode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void intsertElemAtBegin(T data) {
        LNode next = headNode.getNext();
        headNode.setNext(new LNode(data, next));
        size++;
    }

    private void delLastNode() {
        LNode preNode = headNode;
        while(preNode.getNext().getNext()!=null){
            preNode = preNode.getNext();
        }
        LNode temp = preNode.getNext();
        preNode.setNext(null);
        temp = null;
        size--;
    }

    private void insertElementAtBegin(T data) {
        LNode temp = headNode.getNext();
        headNode.setNext(new LNode(data, temp));
        size++;
    }

    private void delNode(LNode node) {
        LNode preNode = headNode;
        while(preNode.getNext() !=null){
            if(preNode.getNext().getElement().equals(node.getElement())){
                LNode temp = preNode.getNext();
                preNode.setNext(temp.getNext());
                temp = null;
                size--;
                return;
            }else{
                preNode = preNode.getNext();
            }
        }
    }

    private LNode findNodeByData(T data) {
        LNode node= headNode.getNext();
        while(node!=null){
            if(data.equals(node.getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    private void printAll() {
        LNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList list = new LRUBaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }


}
