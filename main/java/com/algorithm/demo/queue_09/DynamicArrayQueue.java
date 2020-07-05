package com.algorithm.demo.queue_09;

public class DynamicArrayQueue {

    private String[] arr;
    private static final Integer DEFAULT_CAPACITY=16;
    private int capacity;
    private int head;
    private int end;

    public DynamicArrayQueue(){
        this.arr = new String[DEFAULT_CAPACITY];
        this.capacity = this.head = this.end =0;
    }

    public DynamicArrayQueue(int capacity) {
        this.arr = new String[capacity];
        this.capacity = capacity;
    }

    /**
     * 入队
     * @return
     */
    public boolean enqueue(String item){
        if(end==capacity){
            if(head>0){
                for(int i=0;i<capacity;i++){
                    if(i<end-head){
                        arr[i]=arr[i+head];
                    }else{
                        arr[i]=null;
                    }
                }
                end = end-head;
                head = 0;
            }else if(head==0){
                System.out.println("队列已满");
                return false;
            }
        }
        arr[end] = item;
        end++;
        System.out.println("入队："+item);
        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue(){
        if(head==end){
            System.out.println("队列已空");
            return null;
        }
        String item = arr[head];
        head++;
        System.out.println("出队："+item);
        return item;
    }

    public void printAll(){
        System.out.print("队列包含");
        for(String v:arr){
            System.out.print(" -> "+v);
        }
    }

    public static void main(String[] args) {
        DynamicArrayQueue queue = new DynamicArrayQueue(5);
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
