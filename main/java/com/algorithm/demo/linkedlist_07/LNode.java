package com.algorithm.demo.linkedlist_07;

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