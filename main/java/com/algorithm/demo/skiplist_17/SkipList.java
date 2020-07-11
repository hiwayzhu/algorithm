package com.algorithm.demo.skiplist_17;

/**
 * 跳表
 */
public class SkipList {
    public static final int MAX_HIGH = 16;
    public static final float RANDOM_PARAM = 0.5f;
    private Node head =  new Node(MAX_HIGH);
    private int level = 1;

    public void  insert(int value){
        int newlevel = head.next[0]==null?1:randomLevel();
        if(newlevel>level){
            newlevel = ++level;
        }

        Node newnode = new Node(value,newlevel);

        Node p = head;
        // 从最大层开始查找，找到前一节点，通过--i，移动到下层再开始查找
        for(int i = level-1;i>=0;i--){
            while(p.next[i]!=null&&p.next[i].value<value){
                p = p.next[i];
            }
            // level 会 > newlevel，所以加上判断。比如我从16层开始找，但是我insert的node高度只有3，所以我只有遍历到level<=3时，才会插入
            if(newlevel>i) {
                newnode.next[i] = p.next[i];
                p.next[i] = newnode;
            }
        }
    }

    private int randomLevel() {
        int level = 1;
        while(Math.random()>0.5f&&level<MAX_HIGH){
            level++;
        }
        return level;
    }


    class Node{
        int value = -1;
        //该节点的在不同level的下一个节点集合，比如next[i]表示该节点在第i层的下一个节点
        Node[] next;
        int high;

        public Node(int value,int high){
            this.value = value;
            this.next = new Node[high];
            this.high = high;
        }
        public Node(int high){
            this.next = new Node[high];
            this.high = high;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * 打印所有数据
     */
    public void printAll_beautiful() {
        Node p = head;
        Node[] c = p.next;
        Node[] d = c;
        int maxLevel = c.length;
        for (int i = maxLevel - 1; i >= 0; i--) {
            do {
                System.out.print((d[i] != null ? d[i].value : null) + ":" + i + "-------");
            } while (d[i] != null && (d = d[i].next)[i] != null);
            System.out.println();
            d = c;
        }
    }

    public Node find(int data){
        Node p = head;
        for(int i=level-1;i>=0;i--){
            while(p.next[i]!=null&&p.next[i].getValue()<data){
                p = p.next[i];
            }
        }
        if(p.next[0]!=null&&p.next[0].getValue()==data){
            System.out.println("high:"+p.next[0].high);
            return p.next[0];
        }else{
            System.out.println("不存在");
            return null;
        }
    }

    public static void main(String[] args) {
        SkipList list = new SkipList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(8);
        list.insert(7);
        list.printAll_beautiful();
        list.find(7);
        list.find(10);
    }

}
