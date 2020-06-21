package com.algorithm.demo.linkedlist_06;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LRUBaseArray<T> {

    public static final int DEFAULT_CAPACITY=10;
    T[] array;
    private int capacity;
    private int size;

    public Map<T,Integer> map;

    public LRUBaseArray(){
        this(DEFAULT_CAPACITY);
    }
    public LRUBaseArray(Integer capacity){
        this.capacity = capacity;
        this.size =0;
        this.array = (T[]) new Object[capacity];
        this.map = new HashMap<>(capacity);
    }

    public void add(T data){
        if(data == null){
            System.out.println("can not null!");
            return;
        }
        Integer index = map.get(data);
        if(index!=null){
            T obj = array[index];
            rigthShift(index);
            array[0] = obj;
            map.put(obj,0);
        }else{
            if(size>=capacity){
                removeLast();
            }
            rigthShift(size);
            array[0] = data;
            map.put(data,0);
            size++;
        }
    }

    private void removeLast() {
        T obj = array[capacity-1];
        map.put(obj,null);
        size--;
    }

    private void rigthShift(Integer index) {
        for(int i =index;i>0;i--){
            T obj = array[i-1];
            array[i] = obj;
            map.put(obj,i);
        }
    }

    public void printAll(){
        for(T obj:array){
            System.out.print(obj+",");
        }
    }

    public static void main(String[] args) {
        LRUBaseArray array = new LRUBaseArray();
        Scanner sc = new Scanner(System.in);
        while (true) {
            array.add(sc.nextInt());
            array.printAll();
        }
    }


}
