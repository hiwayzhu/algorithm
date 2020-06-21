package com.algorithm.demo.linkedlist_07;

/**
 * 单链表翻转
 * @param <T>
 */
public class SingleListReverse<T> {

    private int size;
    private LNode headNode;

    public SingleListReverse(){
        this.size = 0;
        this.headNode = new LNode();
    }

    public SingleListReverse(T[] datas){
        this.size=0;
        this.headNode = new LNode();

        if(datas.length>0){
            LNode preNode = headNode;
            for(T data:datas){
                LNode cur = new LNode(data);
                preNode.setNext(cur);
                preNode = cur;
                size++;
            }
        }
    }

    public void reverse(){
        if(size<=0){
            System.out.println("链表为空");
            return;
        }

        LNode cur = headNode.getNext();
        LNode next = cur.getNext();
        LNode tmp = next;
        cur.setNext(null);
        while(next != null){
            tmp = next.getNext();
            next.setNext(cur);
            cur = next;
            next = tmp;
        }

        headNode.setNext(cur);
    }

    public void printAll(){
        LNode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7};
        SingleListReverse singleListReverse = new SingleListReverse<Integer>(arr);
        singleListReverse.reverse();
        singleListReverse.printAll();
    }
}
