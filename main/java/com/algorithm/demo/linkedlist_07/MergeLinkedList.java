package com.algorithm.demo.linkedlist_07;

/**
 * 两有序链表合并
 */
public class MergeLinkedList {

    /**
     * 递归
     * @param l
     * @param r
     * @return
     */
    public LNode merge(LNode l,LNode r){
        if(l==null && r==null){
            return null;
        }
        if(l==null){
            return r;
        }
        if(r==null){
            return l;
        }

        LNode node = null;
        if(l!=null&&r!=null){
            if((Integer)l.getElement()>(Integer)r.getElement()){
                node = r;
                node.setNext(merge(l,r.getNext()));
            }else{
                node = l;
                node.setNext(merge(l.getNext(),r));
            }
        }
        return node;
    }

    public LNode merge2(LNode l,LNode r){
        if(l==null && r==null){
            return null;
        }
        if(l==null){
            return r;
        }
        if(r==null){
            return l;
        }
        LNode head = null;
        LNode cur = null;
        while(l!=null&&r!=null){
            if((Integer)l.getElement()>(Integer)r.getElement()){
                if(head==null){
                    head = r;
                    cur = head;
                }else{
                    cur.setNext(r);
                    cur = r;
                }
                r = r.getNext();
            }else{
                if(head==null){
                    head = l;
                    cur = head;
                }else{
                    cur.setNext(l);
                    cur = l;
                }
                l = l.getNext();
            }
        }

        if(l==null&&r!=null){
           cur.setNext(r);
        }else if(r==null&&l!=null){
            cur.setNext(l);
        }
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
        //[1,3,4,6,7]
        LNode n1 = new LNode(7);
        LNode n2 = new LNode(6,n1);
        LNode n3 = new LNode(4,n2);
        LNode n4 = new LNode(3,n3);
        LNode n5 = new LNode(1,n4);

        //[2,5,8,9]
        LNode n6 = new LNode(9);
        LNode n7 = new LNode(8,n6);
        LNode n8 = new LNode(5,n7);
        LNode n9 = new LNode(2,n8);

        MergeLinkedList mergeLinkedList = new MergeLinkedList();
        //LNode merge = mergeLinkedList.merge(n9, n5);
        LNode merge = mergeLinkedList.merge2(n9, n5);
        mergeLinkedList.printAll(merge);
    }
}
