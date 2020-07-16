package com.algorithm.demo.tree_24;

/**
 * 二叉树
 */
public class BinarySearchTree {
    Node head;

    public void insert(int data){
        if(head==null){
            head = new Node(data);
            return;
        }

        Node node = head;
        while(node!=null){
            if(data>node.value){
                if(node.right==null){
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            }else{
                if(node.left==null){
                    node.left=new Node(data);
                    return;
                }
                node = node.left;
            }
        }
    }

    public void delete(int data){
        Node p = head;
        Node pp = null;
        while(p!=null&&p.value!=data){
            pp = p;
            if(data>p.value){
                p = p.right;
            }else{
                p = p.left;
            }
        }

        if(p==null) return;

        if(p.left!=null&&p.right!=null){
            Node minP = p.right;
            Node minPP = p;
            while(minP.left!=null){
                minPP = minP;
                minP = minP.left;
            }
            p.value = minP.value;
            p = minP; // 下面就变成了删除minP了
            pp = minPP;
        }

        // 删除节点是叶子节点或者仅有一个子节点
        Node child; // p的子节点
        if (p.left != null) child = p.left;
        else if (p.right != null) child = p.right;
        else child = null;

        if (pp == null) head = child; // 删除的是根节点
        else if (pp.left == p) pp.left = child;
        else pp.right = child;
    }



    class Node{
        int value;
        Node left ;
        Node right;

        public Node(int data){
            this.value = data;
        }
    }
}
