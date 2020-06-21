package com.algorithm.demo.linkedlist_07;

/**
 * 寻找中间节点
 */
public class FindMiddleNodeLinkedList {
    public void findMiddleNode(LNode head){
        if(head==null){
            return;
        }
        LNode slow = head;
        LNode fast = head;
        while(fast.getNext()!=null &&fast.getNext().getNext()!=null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }
        if(fast.getNext()!=null){
            System.out.println("中心点为："+slow.getElement()+"和"+slow.getNext().getElement());
        }else{
            System.out.println("中心点为："+slow.getElement());
        }
    }

    public static void main(String[] args) {
        FindMiddleNodeLinkedList findMiddleNodeLinkedList = new FindMiddleNodeLinkedList();
        LNode n1 = new LNode(1);
        LNode n2 = new LNode(2,n1);
        LNode n3 = new LNode(3,n2);
        LNode n4 = new LNode(4,n3);
        LNode n5 = new LNode(5,n4);
        LNode n6 = new LNode(6,n5);
        LNode n7 = new LNode(7,n6);
        LNode n8 = new LNode(8,n7);
        LNode n9 = new LNode(9,n8);
        LNode n10 = new LNode(10,n9);

        findMiddleNodeLinkedList.findMiddleNode(n10);
    }
}
