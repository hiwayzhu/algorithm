package com.algorithm.demo.linkedlist_07;

/**
 * 链表中环的检测
 *
 * 并检测环的开始节点位置
 */
public class RingCheckLinkedList<T> {

    private int size;
    private LNode headNode;

    public RingCheckLinkedList(){
        this.size = 0;
        this.headNode = new LNode();
    }

    public RingCheckLinkedList(LNode node){
        this.headNode = new LNode(null,node);
    }

    public RingCheckLinkedList(T[] datas){
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

    /**
     * 是否有环
     * @return
     */
    public boolean ringCheck(){
        LNode p = headNode;
        LNode q = headNode;
        while(q.getNext()!=null&&q.getNext().getNext()!=null){
            p = p.getNext();
            q = q.getNext().getNext();
            if(p == q){
                return true;
            }
        }
        return false;
    }

    /**
     * 环的起始节点
     * @return
     */
    public Integer ringCheckIndex(){
        LNode p = headNode;
        LNode q = headNode;
        Integer i = -1;
        while(q.getNext()!=null&&q.getNext().getNext()!=null){
            p = p.getNext();
            q = q.getNext().getNext();
            i++;
            if(p == q){
                return i;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8};
        RingCheckLinkedList ringCheckLinkedLisk = new RingCheckLinkedList<Integer>(arr);
        System.out.println(ringCheckLinkedLisk.ringCheck());

        LNode n1 = new LNode(1);
        LNode n2 = new LNode(2,n1);
        LNode n3 = new LNode(3,n2);
        LNode n4 = new LNode(4,n3);
        LNode n5 = new LNode(5,n4);
        LNode n6 = new LNode(6,n5);
        LNode n7 = new LNode(7,n6);
        LNode n8 = new LNode(8,n7);
        LNode n9 = new LNode(9,n8);

        n1.setNext(n5);
        RingCheckLinkedList ringCheckLinkedLisk2 = new RingCheckLinkedList<Integer>(n9);
        System.out.println(ringCheckLinkedLisk2.ringCheck());
        System.out.println(ringCheckLinkedLisk2.ringCheckIndex());
    }
}
