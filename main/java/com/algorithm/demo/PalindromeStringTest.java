package com.algorithm.demo;

import org.springframework.util.StringUtils;

/**
 * 单链表判断回文串
 */
public class PalindromeStringTest<T> {

    private LNode headNode;
    private Integer size;

    public PalindromeStringTest(){

        this.headNode = new LNode();
        this.size = 0;
    }

    public PalindromeStringTest(T[] datas){
        this.headNode = new LNode();
        this.size = 0;

        LNode preNode = headNode;
        if(datas.length>0){
           for (T obj:datas){
               LNode node = new LNode(obj);
               preNode.setNext(node);
               preNode = node;
           }
        }
    }

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

    public boolean palindrome(){
        LNode p = headNode.getNext();
        LNode q = headNode.getNext();
        while(q.next!=null && q.next.next!=null){
            p = p.next;
            q = q.next.next;
        }

        //奇数，中间数为p
        LNode l = new LNode();
        LNode r = new LNode();
        if(q.getNext()==null){
            r = p.next;
            l = inverseLinkList(p).next;
            return TFResult(l,r);
        }else{
            r = p.next;
            l = inverseLinkList(p);
            return TFResult(l,r);
        }
    }

    private boolean TFResult(LNode l, LNode r) {
        while(l!=null&&r!=null){
            if(l.getElement().equals(r.getElement())){
                l=l.next;
                r=r.next;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    private LNode inverseLinkList(LNode p) {
        LNode cur = headNode.next;
        LNode next = cur.next;
        cur.next = null;
        LNode tmp = next;
        while(cur != p){
            tmp = next.next;
            next.next = cur;
            cur = next;
            next = tmp;
        }

        return cur;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,3,3,2,1};
        PalindromeStringTest p = new PalindromeStringTest<Integer>(arr);
        System.out.println(p.palindrome());
    }

}
