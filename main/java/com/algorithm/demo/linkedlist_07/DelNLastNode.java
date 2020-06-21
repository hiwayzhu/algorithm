package com.algorithm.demo.linkedlist_07;

/**
 * 使用单链表，删除倒数第N个节点
 */
public class DelNLastNode {

    public LNode delNLast(LNode head,int n){
        LNode l = head;
        LNode r = head;
        while(n>0){
            r = r.getNext();
            n--;
        }
        while(r.getNext()!=null){
            r = r.getNext();
            l = l.getNext();
        }
        LNode next = l.getNext();
        l.setNext(next.getNext());
        next = null;
        return head;
    }

    public void printAll(LNode node){
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LNode n1 = new LNode(1);
        LNode n2 = new LNode(2,n1);
        LNode n3 = new LNode(3,n2);
        LNode n4 = new LNode(4,n3);
        LNode n5 = new LNode(5,n4);
        LNode n6 = new LNode(6,n5);
        LNode n7 = new LNode(7,n6);
        LNode n8 = new LNode(8,n7);
        LNode n9 = new LNode(9,n8);

        DelNLastNode delNLastNode = new DelNLastNode();
        LNode node = delNLastNode.delNLast(n9, 2);
        delNLastNode.printAll(node);
    }
}
